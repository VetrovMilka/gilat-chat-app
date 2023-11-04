package org.students.ninjas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class IOStream {

    final BufferedInputStream bIn;
    final BufferedOutputStream bOut;

    public IOStream(BufferedInputStream bIn, BufferedOutputStream bOut) {
        super();
        this.bIn = bIn;
        this.bOut = bOut;
    }

    public IOStream() {
        this.bIn = new BufferedInputStream(System.in);
        this.bOut = new BufferedOutputStream(System.out);
    }

    public void send(int value) throws IOException {
        bOut.write(value);
        bOut.flush();
    }

    public int receive() throws IOException {
        if (bIn.available() > 0) {
            return bIn.read();
        }
        return -1;
    }

}
