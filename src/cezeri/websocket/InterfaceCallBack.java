/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cezeri.websocket;

@FunctionalInterface
public interface InterfaceCallBack {
    public abstract void onMessageReceived(String str);
}
