/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Child;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kunjan
 */
public class ChildDirectory {

    List<Child> childList;
    private static ChildDirectory directory;

    public static ChildDirectory getInstance() {
        if (directory == null) {
            directory = new ChildDirectory();
        }
        return directory;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public ChildDirectory() {
        childList = new ArrayList<Child>();
    }

    public Child addChild() {
        Child ch = new Child();
        childList.add(ch);
        return ch;
    }

    public void removeChild(Child ch) {
        childList.remove(ch);
    }

}
