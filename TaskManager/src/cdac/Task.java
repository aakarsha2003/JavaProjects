import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;
import java.util.Timer;

class Task {
    String name;
    LocalDateTime start, end;
    boolean started;
    Task(String name, LocalDateTime start, LocalDateTime end) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.started = false;
    }
}

public class TaskManagerApp extends JFrame {
    private DefaultListModel<Task> taskListModel = new DefaultListModel<>();
    private JList<Task> taskList = new JList<>(taskListModel);

    public TaskManagerApp() {
        setTitle("Task Manager");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton addButton = new JButton("Add Task");
        JButton editButton = new JButton("Edit Task");
        JButton deleteButton = new JButton("Delete Task");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addTask());
        editButton.addActionListener(e -> editTask());
        deleteButton.addActionListener(e -> deleteTask());

        Timer timer = new Timer();
        timer.schedule(new TaskReminder(), 0, 60 * 1000); // check every minute

        setVisible(true);
    }

    void addTask() {
        JTextField nameField = new JTextField();
        JTextField startField = new JTextField("yyyy-MM-dd HH:mm");
        JTextField endField = new JTextField("yyyy-MM-dd HH:mm");
        Object[] fields = {
            "Task Name:", nameField,
            "Start Time:", startField,
            "End Time:", endField
        };
        int result = JOptionPane.showConfirmDialog(this, fields, "Add Task", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                LocalDateTime start = LocalDateTime.parse(startField.getText().trim().replace(" ", "T"));
                LocalDateTime end = LocalDateTime.parse(endField.getText().trim().replace(" ", "T"));
                taskListModel.addElement(new Task(nameField.getText(), start, end));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid date/time. Use format yyyy-MM-dd HH:mm");
            }
        }
    }

    void editTask() {
        Task t = taskList.getSelectedValue();
        if (t == null) return;
        JTextField nameField = new JTextField(t.name);
        JTextField startField = new JTextField(t.start.toString().replace('T', ' '));
        JTextField endField = new JTextField(t.end.toString().replace('T', ' '));
        Object[] fields = {
            "Task Name:", nameField,
            "Start Time:", startField,
            "End Time:", endField
        };
        int result = JOptionPane.showConfirmDialog(this, fields, "Edit Task", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                t.name = nameField.getText();
                t.start = LocalDateTime.parse(startField.getText().trim().replace(" ", "T"));
                t.end = LocalDateTime.parse(endField.getText().trim().replace(" ", "T"));
                taskList.repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid date/time. Use format yyyy-MM-dd HH:mm");
            }
        }
    }

    void deleteTask() {
        Task t = taskList.getSelectedValue();
        if (t != null) taskListModel.removeElement(t);
    }

    class TaskReminder extends TimerTask {
        public void run() {
            for (int i = 0; i < taskListModel.getSize(); i++) {
                Task t = taskListModel.get(i);
                if (!t.started && LocalDateTime.now().isAfter(t.start) && LocalDateTime.now().isBefore(t.end)) {
                    SwingUtilities.invokeLater(() -> {
                        int res = JOptionPane.showOptionDialog(
                            TaskManagerApp.this, "Task: " + t.name + "\nStart Now?",
                            "Task Reminder", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, new String[]{"Take Task", "Ignore"}, "Take Task"
                        );
                        if (res == 0) {
                            t.started = true;
                            Duration left = Duration.between(LocalDateTime.now(), t.end);
                            JOptionPane.showMessageDialog(TaskManagerApp.this, "Time left: " + left.toMinutes() + " minutes");
                        }
                    });
                }
            }
        }
    }

    public static void main(String[] args) {
        new TaskManagerApp();
    }
}

