package dk.easj.anbo.collectwords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String LIST = "LIST";
    private ArrayList<CharSequence> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequenceArrayList(LIST, words);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        words = savedInstanceState.getCharSequenceArrayList(LIST);
    }
    */

    public void clickedSave(View view) {
        EditText input = findViewById(R.id.word_input);
        String word = input.getText().toString();
        words.add(word);
        input.setText("");
    }

    public void clickedClear(View view) {
        words.clear();
    }

    public void clickedShow(View view) {
        // Toast.makeText(this, words.toString(), Toast.LENGTH_LONG).show();
        TextView output = findViewById(R.id.textview_message);
        output.setText(words.toString());
    }
}
