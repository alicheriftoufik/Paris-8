package com.example.toufik.kyodaigame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;

public class MainActivity extends Activity {

    public	Menu	mMenu;
    private MainActivity instance;

    private boolean soundlanched = false;

    private MediaPlayer mMediaPlayerbckgnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);

        final Button ButtonQuitter = (Button) findViewById(R.id.buttonquitter);
        final Button ButtonSon  = (Button) findViewById(R.id.buttonhighscores);
        final Button ButtonJouer   = (Button) findViewById(R.id.buttonJouer);
        final Button Buttonabout   = (Button) findViewById(R.id.buttonabout);



        mMediaPlayerbckgnd = MediaPlayer.create(instance.getBaseContext(), R.raw.son);
        mMediaPlayerbckgnd.setLooping(true);

        ButtonQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ButtonSon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundlanched = !soundlanched;
                if (soundlanched) {
                    ButtonSon.setText(R.string.btn_sonoui);
                    mMediaPlayerbckgnd.start();
                } else {
                    ButtonSon.setText(R.string.btn_sonnon);
                    if(mMediaPlayerbckgnd.isPlaying()) {
                        mMediaPlayerbckgnd.pause();
                    }
                }
            }
        });

        ButtonJouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(instance, kyodai.class);
                startActivity(intent);
            }
        });
        Buttonabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(instance, About.class);
                startActivity(intent2);
            }
        });


    }

    /* *********************************************************** */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /* *********************************************************** */

    /* *********************************************************** */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }
    /* *********************************************************** */

    /* *********************************************************** */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                showAbout();
                return true;
            case R.id.help:
                showHelp();
                return true;
            default:
                return false;
        }
    }
    /* *********************************************************** */


    /* *********************************************************** */
    private void showAbout() {
        AlertDialog.Builder	about = new AlertDialog.Builder(this);
        about.setTitle(
                Html.fromHtml(
                        "<b>Projet Android</b>")
        );
        about.setIcon(R.drawable.ic_about);

        TextView l_viewabout	= new TextView(this);
        l_viewabout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        l_viewabout.setPadding(20, 10, 20, 10);
        l_viewabout.setTextSize(20);
        l_viewabout.setText(
                Html.fromHtml(
                        "<small>TP 2 - PARIS 8 - SNAKE</small>"+
                                "<br/>"+"<br/>"+
                                "<b>Developpé par:</b>"+
                                "<br/>"+
                                "<small>- ALI CHERIF Toufik</small>"+
                                "<br/>"+"<br/>"+
                                "<small></small>"+
                                "<br/>"
                )
        );
        //l_viewabout.setMovementMethod(LinkMovementMethod.getInstance());

        about.setView(l_viewabout);
        about.setPositiveButton(
                "OK",
                new android.content.DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }
        );

        about.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                                      @Override
                                      public void onCancel(DialogInterface dialog) {

                                      }
                                  }
        );

        about.show();
    }
    /* *********************************************************** */

    /* *********************************************************** */
    private void showHelp() {
        AlertDialog.Builder	help = new AlertDialog.Builder(this);

        //TextView l_viewhelp	= new TextView(this);


        help.setTitle(
                Html.fromHtml(
                        "<b>TP2 PARIS 8</b>")
        );
        help.setIcon(R.drawable.aide);
        help.setMessage(
                Html.fromHtml(
                        "<b><u>R�Association des paires:\n" +
                                "\n" +
                                "- Si 2 éléments sont contigus (haut, bas, \n" +
                                "\n" +
                                "gauche, droite). \n" +
                                "\n" +
                                "- Si deux éléments sont séparés par du \n" +
                                "\n" +
                                "vide. \n" +
                                "\n" +
                                "- Il est possible de relier une paire par \n" +
                                "\n" +
                                "les extérieurs de la matrice.gles:</u></b>"+
                                "<br/>"+
                                "<small></small>"+
                                "<br/>"+"<br/>"
                )
        );

        help.setPositiveButton(
                "OK",
                new android.content.DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }
        );

        help.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                                     @Override
                                     public void onCancel(DialogInterface dialog) {

                                     }
                                 }
        );

        help.show();
    }

}
