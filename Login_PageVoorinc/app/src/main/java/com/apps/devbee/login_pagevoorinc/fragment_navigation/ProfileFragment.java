package com.apps.devbee.login_pagevoorinc.fragment_navigation;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.NavigationDrawerActivity;
import com.apps.devbee.login_pagevoorinc.R;
import com.apps.devbee.login_pagevoorinc.TabbedActivity;
import com.apps.devbee.login_pagevoorinc.TransactionDetailActivity;
import com.apps.devbee.login_pagevoorinc.VouriincActivity;

import java.util.Calendar;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    DatePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;
    private ActionMode mActionMode;
    private ActionMode.Callback mCallBack;
    private ImageButton mButton;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        super.onCreate(savedInstanceState);
        tvw=v.findViewById(R.id.textView1);
        eText=v.findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        mCallBack=new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

                MenuInflater inflater = actionMode.getMenuInflater();
                inflater.inflate(R.menu.menu_profile_second, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_back:
                        Toast.makeText(getActivity(), "Go back", Toast.LENGTH_SHORT).show();
                        actionMode.finish();
                        return true;
                    case R.id.action_delete:
                        Toast.makeText(getActivity(), "Delete the data", Toast.LENGTH_SHORT).show();
                        actionMode.finish();
                        return true;
                    case R.id.action_forward:
                        Toast.makeText(getActivity(), "Forward it to", Toast.LENGTH_SHORT).show();
                        actionMode.finish();
                        return true;
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                mActionMode=null;
            }
        };
        eText.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (mActionMode != null) return false;
                mActionMode = getActivity().startActionMode(mCallBack);
                view.setSelected(true);
                return true;
            }
        });
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        btnGet=v.findViewById(R.id.button1);
        registerForContextMenu(btnGet);
        btnGet.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                //Toast.makeText(getContext(), "Long Clicked " , Toast.LENGTH_SHORT).show();
                v.showContextMenu();
                btnGet.setBackgroundColor(Color.BLUE);
                return false;
            }
        });
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Date: "+ eText.getText());
            }
        });

        Toolbar mToolbar =v.findViewById(R.id.toolbar);

        if (mToolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        }
        mToolbar.setTitle(null);
        setHasOptionsMenu(true);

        mButton=v.findViewById(R.id.imageView);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getActivity(), mButton);
                popup.getMenuInflater().inflate(
                        R.menu.menu_profile_second, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
                popup.show();

            }
    });
// define
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent homeIntent = new Intent(getActivity(), TransactionDetailActivity.class);
                //Intent homeIntent = new Intent(getActivity(), TabbedActivity.class);
                Intent homeIntent = new Intent(getActivity(), NavigationDrawerActivity.class);
                getActivity().startActivity(homeIntent);
            }
        });

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_profile,menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                Toast.makeText(getActivity(), "Call Action Order", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_status:
                Toast.makeText(getActivity(), "display the status", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_favorites:
                Toast.makeText(getActivity(), "display favorites", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_contact:
                Toast.makeText(getActivity(), "Show the contact", Toast.LENGTH_SHORT).show();
                return true;
            default:
                    return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater= getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_fragment_profile,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                Toast.makeText(getActivity(), "Call Action Order", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_status:
                Toast.makeText(getActivity(), "display the status", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_favorites:
                Toast.makeText(getActivity(), "display favorites", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_contact:
                Toast.makeText(getActivity(), "Show the contact", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
