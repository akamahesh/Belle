package com.akamahesh.belle.ui.dynamic_views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.akamahesh.belle.R;

public class DynamicActivity extends AppCompatActivity {

  @BindView(R.id.view_vertical)
  RelativeLayout relativeLayout;

  public static Intent getIntent(Context context) {
    return new Intent(context, DynamicActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dynamic);
    ButterKnife.bind(this);

    addViews(30);
  }

  private void addViews(int max) {
    relativeLayout.removeAllViews();
    for (int i = 0; i < max; i++) {
      LinearLayout layout = new LinearLayout(this);
      layout.setOrientation(LinearLayout.HORIZONTAL);
      {
        TextView tvTaxName = new TextView(this);
        tvTaxName.setText("Gst");
        tvTaxName.setPadding(10,10,10,10);
        layout.addView(tvTaxName);
      }
      {
        EditText etTaxValue = new EditText(this);
        etTaxValue.setText("20");
        etTaxValue.setBackground(null);
        etTaxValue.setPadding(10,10,10,10);
        layout.addView(etTaxValue);
      }
      {
        TextView tvTaxType = new TextView(this);
        tvTaxType.setText("%");
        tvTaxType.setPadding(10,10,10,10);
        layout.addView(tvTaxType);
        layout.setPadding(10,10,10,10);
      }

      relativeLayout.addView(layout);
    }
  }
}
