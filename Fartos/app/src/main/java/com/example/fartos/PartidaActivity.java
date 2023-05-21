package com.example.fartos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fartos.RecyclerCartas.Carta;
import com.example.fartos.RecyclerCartas.CartasRecycler;
import com.example.fartos.RecyclerTablero.Casilla;
import com.example.fartos.RecyclerTablero.CasillaRecycler;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;


public class PartidaActivity extends AppCompatActivity {
    int numJugadores;
    LinearLayout tablero;

    List<Casilla> casillas = new ArrayList<>();
    List<Carta> cartas = new ArrayList<>();

    List<Jugador> jugadors = new ArrayList<>();

    private final int NumRondes = 5;

    public enum ResultatMoviment {GUANYADOR, CASELLA_ESPECIAL, CONTINUAR_JOC};

    private final int RondaElimCela = 3;

    private final int MovCasellaEspecial = 5;

    int numRonda = 1;

    private Taulell taulell ;


    private int cartesJugades;
    static int pase = -1 ;
    Jugador jugadorActual;

    Jugador jugadorSelecionado;

    RecyclerView recycler;
    CasillaRecycler adapter = new CasillaRecycler(casillas, this);
    CartasRecycler adapterCartas = new CartasRecycler(cartas);

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ArrayList<Parcelable> parcelableJugadors = extras.getParcelableArrayList("jugadors");
            if (parcelableJugadors != null) {
                for (Parcelable parcelableJugador : parcelableJugadors) {
                    jugadors.add((Jugador) parcelableJugador);
                }
            }
        }



        iniciarJoc(taulell);

        recycler = findViewById(R.id.cartas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(adapterCartas);



        recycler = findViewById(R.id.tablero);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(adapter);
        adapter.add(new Casilla(jugadors));
        for(int i = 0; i< 15; i++){
            adapter.add(new Casilla());
        }

        adapter.setOnItemClick(new CasillaRecycler.OnItemClick() {
            @Override
            public void getPosition(int pos) {
                List<TextView> jugadores = adapter.getJugadores();
                for (int i = 0; i < jugadores.size(); i++) {
                    TextView textView = jugadores.get(i);
                    int finalI = i;
                    int finalI1 = i;
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(finalI < jugadors.size()){
                                jugadorSelecionado = jugadors.get(finalI1);
                            }


                            adapter.notifyDataSetChanged();
                            adapterCartas.notifyDataSetChanged();

                        }
                    });
                }

            }
        });
        /*
        next = findViewById(R.id.mostrar);

        //next.setVisibility(View.INVISIBLE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pase++;


                int pos = jugadors.indexOf(jugadorActual);
                if(pos >= 2){
                    jugadorActual = jugadors.get(0);
                }else{
                    jugadorActual = jugadors.get(pos + 1);
                }


                mostrarCartes(jugadorActual);

                mostrarJugadoActualNombre(jugadorActual);



                if(rondaAcabada()){
                    numRonda++;
                    System.out.println("ronda");
                    if(numRonda >= 3){
                        casillas.remove(0);
                    }
                    repartirCartes();
                }

                if(jugadorActual.getMa().size() == 0){next.performClick();}
                adapter.notifyDataSetChanged();
                adapterCartas.notifyDataSetChanged();

                System.out.println("ronda " + numRonda);

            }
        });
        next.performClick();
        */
        adapterCartas.setOnItemClick(new CartasRecycler.OnItemClick() {
            @Override
            public void getPosition(int pos) {
                if(numRonda >= 3  && pase%jugadors.size() == 0){

                }
                casillaEspecial();
                switch(jugadorActual.getMa().get(pos).getEfecte()) {
                    case HUNDIMIENTO:
                    {
                        if(jugadorSelecionado == null){
                            Toast.makeText(PartidaActivity.this, "seleciona un jugador", Toast.LENGTH_SHORT).show();
                        }else {
                            jugadorActual.removdeCarta(pos);
                            casillas.get(jugadorSelecionado.getPosition()).setJugador(jugadors.indexOf(jugadorSelecionado) + 1, "");
                            jugadorSelecionado.setPosition(0);
                            casillas.get(0).setJugador(jugadors.indexOf(jugadorSelecionado) + 1, jugadorSelecionado.getNom());
                            canviarJugadorActual();
                        }
                        break;
                    }
                    case ZANCADILLA:
                    {
                        if(jugadorSelecionado == null){
                            Toast.makeText(PartidaActivity.this, "seleciona un jugador", Toast.LENGTH_SHORT).show();

                        }else {
                            if (!jugadorSelecionado.isZancadilla()) {
                                Random rnd = new Random();
                                jugadorActual.removdeCarta(pos);
                                jugadorSelecionado.setZancadilla(true);
                                if (jugadorSelecionado.getMa().size() >= 1)
                                    jugadorSelecionado.getMa().remove(rnd.nextInt(jugadorSelecionado.getMa().size()));
                            }
                            jugadorSelecionado = null;
                            canviarJugadorActual();


                        }

                        break;
                    }

                    case PATADA:
                    {
                        if(jugadorSelecionado == null){
                            Toast.makeText(PartidaActivity.this, "seleciona un jugador", Toast.LENGTH_SHORT).show();
                        }else{
                            jugadorActual.removdeCarta(pos);
                            jugadorSelecionado.setPatada(true);
                            jugadorSelecionado = null;
                            canviarJugadorActual();
                        }
                        break;
                    }

                    case BROMA:
                    {
                        if(jugadorSelecionado == null){
                            Toast.makeText(PartidaActivity.this, "seleciona un jugador", Toast.LENGTH_SHORT).show();
                        }else {
                            jugadorActual.removdeCarta(pos);
                            List<Carta> cartesJugador = jugadorActual.getMa();
                            List<Carta> cartasJugadorContrari = jugadorSelecionado.getMa();


                            jugadorActual.setMa(cartasJugadorContrari);
                            jugadorSelecionado.setMa(cartesJugador);

                            jugadorSelecionado = null;
                            canviarJugadorActual();
                        }

                        adapter.notifyDataSetChanged();
                        adapterCartas.notifyDataSetChanged();


                        break;
                    }
                    case TELEPORT:
                    {
                        if(jugadorSelecionado == null){
                            Toast.makeText(PartidaActivity.this, "seleciona un jugador", Toast.LENGTH_SHORT).show();
                        }else{
                            jugadorActual.removdeCarta(pos);
                            int jugadorpos = jugadorActual.getPosition();
                            jugadorActual.setPosition(jugadorSelecionado.getPosition());
                            jugadorSelecionado.setPosition(jugadorpos);
                            casillas.get(jugadorpos).setJugador(jugadors.indexOf(jugadorActual) + 1, "" );
                            casillas.get(jugadorActual.getPosition()).setJugador(jugadors.indexOf(jugadorSelecionado) + 1, "" );
                            casillas.get(jugadorpos).setJugador(jugadors.indexOf(jugadorSelecionado) + 1, jugadorSelecionado.getNom() );

                            casillas.get(jugadorActual.getPosition()).setJugador(jugadors.indexOf(jugadorActual) + 1, jugadorActual.getNom() );


                            jugadorSelecionado = null;
                            canviarJugadorActual();
                        }

                        adapter.notifyDataSetChanged();
                        adapterCartas.notifyDataSetChanged();

                    }
                    case MOV_3:
                    {
                        int step = 3;

                        if(jugadorSelecionado == null){
                            Toast.makeText(PartidaActivity.this, "seleciona un jugador", Toast.LENGTH_SHORT).show();
                        }else{
                            jugadorActual.removdeCarta(pos);
                            if(jugadorSelecionado == jugadorActual){
                                mover(jugadorActual, step);

                                jugadorSelecionado = null;
                            }else{

                                mover(jugadorSelecionado, -step);

                                jugadorSelecionado = null;
                            }
                            canviarJugadorActual();
                        }
                        adapter.notifyDataSetChanged();
                        adapterCartas.notifyDataSetChanged();
                    }
                        break;
                    case MOV_2:
                    {
                        int step = 2;

                        if(jugadorSelecionado == null){
                            Toast.makeText(PartidaActivity.this, "seleciona un jugador", Toast.LENGTH_SHORT).show();
                        }else{
                            jugadorActual.removdeCarta(pos);
                            if(jugadorSelecionado == jugadorActual){
                                mover(jugadorActual, step);
                                jugadorSelecionado = null;
                            }else{

                                mover(jugadorSelecionado, -step);
                                jugadorSelecionado = null;

                            }
                            canviarJugadorActual();
                        }
                        adapter.notifyDataSetChanged();
                        adapterCartas.notifyDataSetChanged();
                    }
                        break;
                    case MOV_1:
                    {
                        int step = 1;

                        if(jugadorSelecionado == null){
                            Toast.makeText(PartidaActivity.this, "seleciona un jugador", Toast.LENGTH_SHORT).show();
                        }else{
                            jugadorActual.removdeCarta(pos);

                            if(jugadorSelecionado == jugadorActual){
                                mover(jugadorActual, step);
                                jugadorSelecionado = null;
                            }else{
                                mover(jugadorSelecionado, -step);
                                jugadorSelecionado = null;

                            }

                            canviarJugadorActual();

                        }
                        adapter.notifyDataSetChanged();
                        adapterCartas.notifyDataSetChanged();
                    }
                        break;
                    default:
                }
            }
        });


    }

    private boolean rondaAcabada() {
        boolean fin = true;
        for (Jugador jugador:jugadors){
            if(jugador.getMa().size() != 0){
                fin = false;
                break;
            }
        }
        return fin;
    }

    public void casillaEspecial(){

        if(jugadorActual.getPosition() == 7){
            int step = 5;

            if(jugadorSelecionado == null){
                Toast.makeText(PartidaActivity.this, "seleciona un jugador", Toast.LENGTH_SHORT).show();
            }else{


                if(jugadorSelecionado == jugadorActual){
                    mover(jugadorActual, step);

                    jugadorSelecionado = null;
                }else{
                    mover(jugadorSelecionado, -step);
                    jugadorSelecionado = null;

                }

                canviarJugadorActual();

            }
            adapter.notifyDataSetChanged();
            adapterCartas.notifyDataSetChanged();
        }

    }

    public void mover(Jugador jugador, int step){
        if(jugadorSelecionado.getPosition() + step >= 0 ){
            casillas.get(jugador.getPosition()).setJugador(jugadors.indexOf(jugador) + 1, "");
            casillas.get(jugador.getPosition() + step).setJugador(jugadors.indexOf(jugador) + 1, jugador.getNom());
            jugador.setPosition(jugador.getPosition() + step);
        }else{
            casillas.get(jugador.getPosition()).setJugador(jugadors.indexOf(jugador) + 1, "");
            casillas.get(0).setJugador(jugadors.indexOf(jugador) + 1, jugador.getNom());
            jugador.setPosition(0);
        }


    }

    public void jugadorCartasSleccionado(Jugador jugador, int pos){

        String nom = jugador.getNom();
        int  i = jugadors.indexOf(jugador);
        List<TextView> jugadores = this.adapter.getJugadores();
        TextView textView = jugadores.get(i);
        int finalI = i;

        int viewId = textView.getId();
        jugadorActual = jugadors.get(finalI);
        casillas.get(pos).setJugador(i, "");
        casillas.get(pos + 1).setJugador(i, nom);

        adapter.notifyDataSetChanged();
        adapterCartas.notifyDataSetChanged();


    }

    public void mostrarJugadoActualNombre(Jugador jugador){
        TextView inf = (TextView) findViewById(R.id.jugador_actual);

        inf.setText(jugador.getNom());
    }

    //FUNCIONA
    private void repartirCartes() {
        List<Carta> ma;

        taulell = crearTaulell(jugadors.toArray(new Jugador[0]));

        // Crea la baralla
        cartas = Carta.generarBaralla();

        // Reparteix a cada jugador la ma
        for (Jugador jugador : taulell.getJugadors()) {
            ma = cartas.subList(0, taulell.NumCartes); // Crea la ma
            jugador.setMa(ma); // Assigna la ma al jugador

            cartas.removeAll(ma); // Elimina les cartas de la baralla
        }
    }

    public void ganador(){
        if(jugadors.size() == 1){
            Toast.makeText(PartidaActivity.this, "ganador es " + jugadors.get(0).getNom(), Toast.LENGTH_SHORT).show();
        }else{
            for (Jugador jugador: jugadors){
                if(jugador.getPosition() == casillas.size() - 1){
                    Toast.makeText(PartidaActivity.this, "ganador es " + jugador.getNom(), Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }


    }

    //FUNCIONA
    private void canviarJugadorActual() {
        ganador();

        Random rnd = new Random();
        int indexJugadorActual;
        List<Jugador> jugadors = taulell.getJugadors();

        // Si no hi ha un jugador actual n'assigna un aleatori
        if (jugadorActual == null) {
            indexJugadorActual = rnd.nextInt(this.taulell.getTaulell().size());
            int i = 0;
            for (ListIterator<Jugador> jugador = taulell.getJugadors().listIterator();
                 jugador.hasNext() && i <= indexJugadorActual;
                 i++) {

                if (i == indexJugadorActual) jugadorActual = jugador.next();
            }
        }

        // Si hi ha un jugador assignat canvia al següent
        else {
            if (jugadors.indexOf(jugadorActual) == jugadors.size() - 1)
                jugadorActual = jugadors.get(0);

            else
                jugadorActual = jugadors.listIterator(jugadors.indexOf(jugadorActual) + 1).next();
        }


        if(rondaAcabada()){
            numRonda++;
            System.out.println("ronda");
            if(numRonda >= 3){
                casillas.remove(0);
                for(Jugador jugador: taulell.getJugadors()){

                    if(jugador.getPosition() == 0){
                        this.taulell.eliminarJugador(jugador);

                        this.jugadors.remove(this.jugadors.indexOf(jugador));
                    }
                    jugador.setPosition(jugador.getPosition() - 1);

                }


            }
            repartirCartes();
        }

        if (jugadorActual.getMa().size() == 0) {canviarJugadorActual();}

        pase++;


        mostrarCartes(jugadorActual);

        mostrarJugadoActualNombre(jugadorActual);





        adapter.notifyDataSetChanged();
        adapterCartas.notifyDataSetChanged();
        if(pase%jugadors.size() == 0 && numRonda >= 3) {
            for(Jugador jugador: taulell.getJugadors()){
                if(jugador.getPosition() == 0){
                    this.taulell.eliminarJugador(jugador);
                    this.jugadors.remove(this.jugadors.indexOf(jugador));
                }
                jugador.setPosition(jugador.getPosition() - 1);
            }
            casillas.remove(0);
        }

        System.out.println("ronda " + numRonda);



    }

    private Taulell crearTaulell(Jugador[] jugadors) {

        Taulell taulell = null;

        while (taulell == null) {

            try {
                taulell = new Taulell(jugadors);
            } catch (IllegalArgumentException e) {
            }
        }

        return taulell;
    }

    public void iniciarJoc(Taulell taulell) {
        this.taulell = taulell;

        numRonda = 1;
        cartesJugades = 0;

        repartirCartes();
        canviarJugadorActual();

    }

    public void mostrarCartes(Jugador jugador) {
        adapterCartas.flush();
        adapterCartas.add(jugadors.get(jugadors.indexOf(jugador)).getMa());
        adapterCartas.notifyDataSetChanged();

    }


}