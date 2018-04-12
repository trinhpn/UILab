package group7.tcss450.uw.edu.uilab;


import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBoxRadioButtonFragment extends Fragment {

    private boolean meatChosen;
    private boolean cheeseChosen;
    private boolean sauceChosen;
    private boolean veggiesChosen;
    public CheckBoxRadioButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_check_box_radio_button, container, false);
        RadioButton rb = (RadioButton) v.findViewById(R.id.radioYes);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(view);
            }
        });

        rb = (RadioButton) v.findViewById(R.id.radioNo);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(view);
            }
        });

        /*
        CheckBox cb = (CheckBox) v.findViewById(R.id.cbCheese);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxItemSelected(view);
            }
        });
        cb = (CheckBox) v.findViewById(R.id.cbMeat);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxItemSelected(view);
            }
        });
        cb = (CheckBox) v.findViewById(R.id.cbSauce);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxItemSelected(view);
            }
        });
        cb = (CheckBox) v.findViewById(R.id.cbVeggies);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxItemSelected(view);
            }
        });
        */
        Button b = v.findViewById(R.id.submit_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Inside onClick", "Clicked");

                onSubmitButtonClicked(view);
            }
        });
        return v;
    }

    @Override
    public void onStop() {
        Log.d("", "OnStop is executing");
        super.onStop();
        GradientDrawable bg = (GradientDrawable)
                getActivity().findViewById(R.id.radioGroup).getBackground();
        bg.setColor(getResources().getColor(R.color.fill));
    }

    public void onSubmitButtonClicked(View view) {
        StringBuilder sb = new StringBuilder();
        CheckBox cheese = (CheckBox) getActivity().findViewById(R.id.cbCheese);
        CheckBox meat = (CheckBox) getActivity().findViewById(R.id.cbMeat);
        CheckBox sauce = (CheckBox) getActivity().findViewById(R.id.cbSauce);
        CheckBox veggies = (CheckBox) getActivity().findViewById(R.id.cbVeggies);
        if(cheese.isChecked()) {
            sb.append("cheese ");
        }
        if(meat.isChecked()) {
            sb.append("meat ");
        }
        if(sauce.isChecked()) {
            sb.append("sauce ");
        }
        if(veggies.isChecked()) {
            sb.append("veggies ");
        }

        Toast.makeText(getActivity(), ""+ sb, Toast.LENGTH_LONG).show();

    }
    /*
    public void onCheckboxItemSelected(View view) {
        Log.w("Button","button: " + view.getId());
        boolean check = ((CheckBox) view).isSelected();
        switch(view.getId()) {
            case R.id.cbCheese:
                cheeseChosen = check;
                break;
            case R.id.cbMeat:
                meatChosen = check;
                break;
            case R.id.cbSauce:
                sauceChosen = check;
                break;
            case R.id.cbVeggies:
                veggiesChosen = check;
                break;
        }
    }
    */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        GradientDrawable bg = (GradientDrawable)
                getActivity().findViewById(R.id.radioGroup).getBackground();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioYes:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.yes));
                break;
            case R.id.radioNo:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.no));
                break;
        }
    }


}
