package com.example.weswing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MogudaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CardViewItem> items;

    public MogudaAdapter(List<CardViewItem> items) {
        this.items = items;
    }

    public static class TitleViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;

        public TitleViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
        }
    }

    public static class ToggleButtonViewHolder extends RecyclerView.ViewHolder {
        public ToggleButton toggleButton;

        public ToggleButtonViewHolder(View itemView) {
            super(itemView);
            toggleButton = itemView.findViewById(R.id.toggleButton);
        }
    }

    public static class OrganizerViewHolder extends RecyclerView.ViewHolder {
        public ImageView photoImageView;
        public TextView nameTextView;

        public OrganizerViewHolder(View itemView) {
            super(itemView);
            photoImageView = itemView.findViewById(R.id.photoImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }
    }

    public static class DescriptionViewHolder extends RecyclerView.ViewHolder {
        public TextView descriptionTextView;

        public DescriptionViewHolder(View itemView) {
            super(itemView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }

    public static class AttendeesViewHolder extends RecyclerView.ViewHolder {
        public TextView attendeesTextView;

        public AttendeesViewHolder(View itemView) {
            super(itemView);
            attendeesTextView = itemView.findViewById(R.id.attendeesTextView);
        }
    }

    public static class ImagesViewHolder extends RecyclerView.ViewHolder {
        public TextView imagesTextView;

        public ImagesViewHolder(View itemView) {
            super(itemView);
            imagesTextView = itemView.findViewById(R.id.imagesTextView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == CardViewItem.VIEW_TYPE_TITLE) {
            View view = inflater.inflate(R.layout.cardview_title, parent, false);
            return new TitleViewHolder(view);
        } else if (viewType == CardViewItem.VIEW_TYPE_TOGGLE_BUTTON) {
            View view = inflater.inflate(R.layout.cardview_toggle_button, parent, false);
            return new ToggleButtonViewHolder(view);
        } else if (viewType == CardViewItem.VIEW_TYPE_ORGANIZER) {
            View view = inflater.inflate(R.layout.cardview_organizer, parent, false);
            return new OrganizerViewHolder(view);
        } else if (viewType == CardViewItem.VIEW_TYPE_DESCRIPTION) {
            View view = inflater.inflate(R.layout.cardview_description, parent, false);
            return new DescriptionViewHolder(view);
        } else if (viewType == CardViewItem.VIEW_TYPE_ATTENDEES) {
            View view = inflater.inflate(R.layout.cardview_attendees, parent, false);
            return new AttendeesViewHolder(view);
        } else if (viewType == CardViewItem.VIEW_TYPE_IMAGES) {
            View view = inflater.inflate(R.layout.cardview_images, parent, false);
            return new ImagesViewHolder(view);
        }

        throw new IllegalArgumentException("ViewType desconocido");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CardViewItem item = items.get(position);

        if (holder instanceof TitleViewHolder) {
            TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
            TitleCardViewItem titleItem = (TitleCardViewItem) item;
            titleViewHolder.titleTextView.setText(titleItem.getTitle());
        } else if (holder instanceof ToggleButtonViewHolder) {
            ToggleButtonViewHolder toggleButtonViewHolder = (ToggleButtonViewHolder) holder;
            // Configurar el ToggleButton según sea necesario
        } else if (holder instanceof OrganizerViewHolder) {
            OrganizerViewHolder organizerViewHolder = (OrganizerViewHolder) holder;
            OrganizerCardViewItem organizerItem = (OrganizerCardViewItem) item;
            organizerViewHolder.photoImageView.setImageResource(organizerItem.getPhoto());
            organizerViewHolder.nameTextView.setText(organizerItem.getName());
        } else if (holder instanceof DescriptionViewHolder) {
            DescriptionViewHolder descriptionViewHolder = (DescriptionViewHolder) holder;
            DescriptionCardViewItem descriptionItem = (DescriptionCardViewItem) item;
            descriptionViewHolder.descriptionTextView.setText(descriptionItem.getDescription());
        } else if (holder instanceof AttendeesViewHolder) {
            AttendeesViewHolder attendeesViewHolder = (AttendeesViewHolder) holder;
            AttendeesCardViewItem attendeesItem = (AttendeesCardViewItem) item;
            attendeesViewHolder.attendeesTextView.setText(attendeesItem.getAttendeesCount());
        } else if (holder instanceof ImagesViewHolder) {
            ImagesViewHolder imagesViewHolder = (ImagesViewHolder) holder;
            ImagesCardViewItem imagesItem = (ImagesCardViewItem) item;
            imagesViewHolder.imagesTextView.setText(imagesItem.getImagesText());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
