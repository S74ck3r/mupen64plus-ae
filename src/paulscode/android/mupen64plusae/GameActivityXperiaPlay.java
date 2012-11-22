/**
 * Mupen64PlusAE, an N64 emulator for the Android platform
 * 
 * Copyright (C) 2012 Paul Lamb
 * 
 * This file is part of Mupen64PlusAE.
 * 
 * Mupen64PlusAE is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * Mupen64PlusAE is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU General Public License for more details. You should have received a copy of the GNU
 * General Public License along with Mupen64PlusAE. If not, see <http://www.gnu.org/licenses/>.
 * 
 * Authors: littleguy77
 */
package paulscode.android.mupen64plusae;

import paulscode.android.mupen64plusae.util.FileUtil;
import android.annotation.TargetApi;
import android.app.NativeActivity;
import android.os.Bundle;
import android.util.Log;

@TargetApi( 9 )
public class GameActivityXperiaPlay extends NativeActivity
{
    static
    {
        FileUtil.loadNativeLibName( "xperia-touchpad" );
    }
    
    public native int RegisterThis();
    
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        RegisterThis();
        super.onCreate( savedInstanceState );
    }
    
    public boolean onNativeMotion( int action, int x, int y, int source, int device_id )
    {
        Log.i( "GameActivityXperiaPlay", "Received native motion event! (" + x + ", " + y
                + ") (action:" + action + ") (source:" + source + ")" );
        return true;
    }
    
    public boolean onNativeKey( int action, int keycode )
    {
        Log.i( "GameActivityXperiaPlay", "Received native key event! (" + keycode + ") (action:"
                + action + ")" );
        return false;
    }
}
