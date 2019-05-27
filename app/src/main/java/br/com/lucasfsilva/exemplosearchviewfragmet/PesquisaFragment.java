package br.com.lucasfsilva.exemplosearchviewfragmet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

public class PesquisaFragment extends Fragment implements SearchView.OnQueryTextListener {
    private TextView tvResultado;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmet_pesquisa, container, false);
        tvResultado = (TextView) view.findViewById(R.id.tvResultado);

        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            tvResultado.setText("Sem resultados!");
        } else {
            tvResultado.setText(newText);
        }
        return false;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem menuItem = menu.findItem(R.id.itPesquisa);
        SearchView shvPesquisa = (SearchView) menuItem.getActionView();
        shvPesquisa.setOnQueryTextListener(this);
        shvPesquisa.setQueryHint("Pesquisa");

        super.onCreateOptionsMenu(menu, inflater);
    }
}
