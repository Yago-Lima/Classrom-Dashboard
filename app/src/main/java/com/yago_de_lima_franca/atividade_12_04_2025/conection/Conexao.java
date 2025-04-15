package com.yago_de_lima_franca.atividade_12_04_2025.conection;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class Conexao {
    public static InputStream obterRespostaHTTP(String end) throws IOException {
        HttpsURLConnection con = null;
        try {
            URL url = new URL(end);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int responseCode = con.getResponseCode();
            Log.d("HTTP", "Status Code: " + responseCode); // Adicione este log

            if (responseCode != HttpsURLConnection.HTTP_OK) {
                // Lê a mensagem de erro se houver
                InputStream errorStream = con.getErrorStream();
                String errorMessage = errorStream != null ?
                        new Scanner(errorStream).useDelimiter("\\A").next() :
                        "Sem mensagem de erro";

                throw new IOException("Erro HTTP " + responseCode + ": " + errorMessage);
            }

            return new BufferedInputStream(con.getInputStream());
        } catch (MalformedURLException e) {
            throw new IOException("URL inválida: " + end, e);
        } finally {
            // Não feche a conexão aqui - isso fecharia o InputStream retornado
        }
    }
}