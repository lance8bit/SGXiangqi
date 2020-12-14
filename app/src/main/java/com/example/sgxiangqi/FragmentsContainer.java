package com.example.sgxiangqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.sgxiangqi.ui.fragmentplayers.FragmentPlayers;
import com.example.sgxiangqi.ui.fragmentxiangqiboard.FragmentXiangQiBoard;

public class FragmentsContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_container_activity);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FragmentPlayers.newInstance())
                    .commitNow();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help_settings:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Reglamento");
                builder.setMessage(Html.fromHtml("<p>El juego se practica en un tablero con diez líneas horizontales y nueve verticales. Las piezas se ubican en sus intersecciones, llamadas puntos. En el centro de cada lado del tablero se sitúa una fortaleza de tres puntos de ancho y tres de largo, cruzada por diagonales, en la que se   encuentra el rey. Entre la quinta y la sexta fila se encuentra el río, que divide el tablero en dos. En otras versiones del tablero que son jugadas fuera de China en lugar de haber un río, hay una simple línea.</p>\n" +
                        " \n" +
                        "<p>Elefante (Xiang): mueve dos intersecciones en diagonal, siempre y cuando el punto intermedio esté vacío. No puede atravesar el río.</p>\n" +
                        "\n" +
                        "<p>General —o Rey— (Jiang-Shuai): mueve una intersección en dirección horizontal o vertical, movimiento parecido al rey del ajedrez occidental, pero no puede salir de las casillas marcadas como palacio. Y no puede tener visión directa con el general del oponente, es decir si están en la  misma columna debe haber al menos otra ficha entre medias de ellas dos, se puede aprovechar esto para forzar a no mover al otro jugador.</p>\n" +
                        "\n" +
                        "<p>Oficial —o Consejero— (Shi): mueve una intersección en dirección diagonal, parecido al rey del ajedrez occidental, pero no puede salir de las  casillas marcadas como palacio.</p>\n" +
                        "\n" +
                        "<p>Caballo (Ma): mueve una intersección en dirección horizontal o vertical, seguida de otra en diagonal. El punto de pivote debe estar vacío.</p>\n" +
                        "\n" +
                        "<p>Carro de guerra (Che): mueve como la torre del ajedrez común.</p>\n" +
                        "\n" +
                        "<p>Cañón (Pao): mueve igual que el carro, pero solo puede capturar si salta sobre otra pieza que se encuentre en la línea de ataque. La pieza que se interpone, conocida como plataforma del cañón, puede pertenecer a cualquier bando. El cañón sólo puede saltar si realiza una captura, y no puede saltar sobre dos o más piezas.</p>\n" +
                        "\n" +
                        "<p>Soldado (Bing-Zu): mueve una intersección hacia adelante si se halla en su propio campo; en campo enemigo pueden también mover una intersección en forma horizontal. No puede retroceder, y al llegar a la última línea enemiga sólo mueven en forma lateral. No hay promoción.</p>\n" +
                        "\n" +
                        "<p><b>El final de la partida</b></p>\n" +
                        "\n" +
                        "<p>La partida termina cuando un jugador da jaque mate a su oponente. No hay ahogado en ajedrez chino; en la situación en que un bando se halla sin movimiento legal, pierde la partida. También si el soldado llega al centro del palacio imperial del otro jugador este jugador gana la partida.</p>\n"));
                builder.setNegativeButton("Cerrar", null);
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            case R.id.aboutus_settings:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("Sobre nosotros");
                builder2.setMessage("Desarrollado por Stephen Gonzalez Cedeño, alumno del Grado Superior de aplicaciones multiplataforma.");
                builder2.setNegativeButton("Cerrar", null);
                AlertDialog dialog2 = builder2.create();
                dialog2.show();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


}