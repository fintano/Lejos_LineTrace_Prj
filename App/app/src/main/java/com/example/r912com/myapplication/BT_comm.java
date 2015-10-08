package com.example.r912com.myapplication;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.UUID;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
        import android.bluetooth.BluetoothSocket;

        import android.util.Log;

        public class BT_comm {

            //Target NXTs for communication
            final String nxt = "00:16:53:48:80:82";

            BluetoothAdapter localAdapter;
            BluetoothSocket socket_nxt1;
            boolean success = false;

            //Enables Bluetooth if not enabled
            public void enableBT() {
        localAdapter = BluetoothAdapter.getDefaultAdapter();
        //If Bluetooth not enable then do it
        if (localAdapter.isEnabled() == false) {
            localAdapter.enable();
            while (!(localAdapter.isEnabled())) {

            }
        }

    }
    //connect to both NXTs
    public boolean connectToNXTs() {

        //get the BluetoothDevice of the NXT
        BluetoothDevice nxt_1 = localAdapter.getRemoteDevice(nxt);
        //try to connect to the nxt
        try {
            socket_nxt1 = nxt_1.createRfcommSocketToServiceRecord(UUID
                    .fromString("00001101-0000-1000-8000-00805F9B34FB"));

            socket_nxt1.connect();

            success = true;
        } catch (IOException e) {
            Log.d("Bluetooth", "Err: Device not found or cannot connect");
            success = false;
        }
        return success;
    }
}