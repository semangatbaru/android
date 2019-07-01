package com.example.smsgatewayclient;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.net.URI;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args)
            throws URISyntaxException, InterruptedException {
        URI server = new URI("ws://192.168.43.1:6868");
        SmsGatewayClient client = new SmsGatewayClient(server);
// menyalakan koneksi
        client.connectBlocking();
// membuat Json message
        JsonObject object = new JsonObject();
        object.add("to", new JsonPrimitive("085784845637"));
        object.add("message", new JsonPrimitive("Halo"));
// mengkonversi ke JSON String
        Gson gson = new Gson();
        String json = gson.toJson(object);
// mengirim pesan ke server
        client.send(json);
// memutuskan koneksi
        client.closeBlocking();
    }
}
