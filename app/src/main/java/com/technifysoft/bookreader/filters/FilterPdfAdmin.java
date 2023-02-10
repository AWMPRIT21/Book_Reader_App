package com.technifysoft.bookreader.filters;
import android.widget.Filter;

import com.technifysoft.bookreader.adapters.AdapterCategory;
import com.technifysoft.bookreader.adapters.AdapterPdfAdmin;
import com.technifysoft.bookreader.models.ModelCategory;
import com.technifysoft.bookreader.models.ModelPdf;

import java.util.ArrayList;

public class FilterPdfAdmin extends Filter {

    ArrayList<ModelPdf> filterList;

    AdapterPdfAdmin adapterPdfAdmin;

    public FilterPdfAdmin(ArrayList<ModelPdf> filterList, AdapterPdfAdmin adapterPdfAdmin) {
        this.filterList = filterList;
        this.adapterPdfAdmin = adapterPdfAdmin;
    }


    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        if(constraint !=null && constraint.length()>0){


            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdf> filterModels = new ArrayList<>();


            for (int i=0; i<filterList.size(); i++){


                if(filterList.get(i).getTitle().toUpperCase().contains(constraint)){
                    filterModels.add(filterList.get(i));
                }
            }
            results.count=filterModels.size();
            results.values=filterModels;
        }
        else {

            results.count=filterList.size();
            results.values=filterList;

        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
            adapterPdfAdmin.categoryArrayList = (ArrayList<ModelPdf>)results.values;

            adapterPdfAdmin.notifyDataSetChanged();
    }
}

