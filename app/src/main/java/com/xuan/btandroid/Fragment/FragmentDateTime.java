package com.xuan.btandroid.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;

import com.xuan.btandroid.R;

import java.util.Calendar;

/**
 * Created by HP on 16-Apr-18.
 */

public class FragmentDateTime extends DialogFragment implements DatePickerDialog.OnDateSetListener
{
    DatePickerDialog datePickerDialog;
    EditText edtngaysinh;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Calendar calendar=Calendar.getInstance();
        int nam=calendar.get(Calendar.YEAR);
        int thang=calendar.get(Calendar.MONTH);
        int ngay=calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this ,nam,thang,ngay);

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
    {
        int thang=i1+1;
        String ngaysinh=i2+"/"+thang+"/"+i;
        edtngaysinh=(EditText)getActivity().findViewById(R.id.edtngaysinh);
        edtngaysinh.setText(ngaysinh);

    }
}
