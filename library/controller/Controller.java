/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;
import GUI.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.Object;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Controller {
    private JPanel root;
    private String Selected = "";
    private List<category> cate = null;
    

   public Controller(JPanel jpnRoot){
       this.root = jpnRoot;
       
   }
    public void setView(JPanel jpnItem){
        Selected = "Default";
        jpnItem.setBackground(new Color(43,152,54));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new JPnDefault());
        root.validate();
        root.repaint();
        }
    public void setEvent(List<category> cate){
        this.cate = cate;
        for(category item: cate){
            item.getJpn().addMouseListener(new PanelEvent(item.getKind(),item.getJpn()));
        }
    }
    

class PanelEvent implements MouseListener{
    JPanel node;
    String kind;
    JPanel jpnItem;
    JLabel jlbitem;
    public PanelEvent(String kind, JPanel jpnItem) {
        this.kind = kind;
        this.jpnItem = jpnItem;
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        switch(kind){
            case "Books":
                node = new JPnBooks();
                break;
            case "Search":
                node = new JPnSearch();
                break;
            case "Service":
                node = new JPnService();
                break;
            case "Employee":
                node = new JPnEmployee();
                break;
            case "Storage":
                node = new JPnStorage();
                break;
            case "Reader":
                node = new JPnReader();
                break;
            case "Default":
                node = new JPnDefault();
                break;
            case "Analyze":
                node = new JPnAnalyze();
                break;
            default:
                node = new JPnDefault();
                break;
                
        }
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(node);
        root.validate();
        root.repaint();
        setChangeBackground(kind);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Selected = kind;
        jpnItem.setBackground(new Color(43,120,54));
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!Selected.equalsIgnoreCase(kind)){
            jpnItem.setBackground(new Color(43,152,64));
        }
    }
    private void setChangeBackground(String kind){
        for(category item: cate){
            if(item.getKind().equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(43,120,54));
            }
            else{
                jpnItem.setBackground(new Color(43,152,64));
            }
            
        }
    }
    
}
}