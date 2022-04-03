package dummy.example.table.controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import dummy.example.table.model.Person;
import dummy.example.table.view.FrmTableExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CtrTableExample {
    FrmTableExample frame;
    JTable tablePerson;

    public CtrTableExample(FrmTableExample frame) {
        this.frame = frame;
    }
}
