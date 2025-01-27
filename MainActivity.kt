import 'package:flutter/material.dart';

void main() {
    runApp(TaskManagerApp());
}

class TaskManagerApp extends StatelessWidget {
    @override
    Widget build(BuildContext context) {
        return MaterialApp(
            debugShowCheckedModeBanner: false,
        title: 'Task Manager',
        theme: ThemeData(
        primarySwatch: Colors.blue,
        ),
        home: TaskManagerScreen(),
        );
    }
}

class TaskManagerScreen extends StatefulWidget {
    @override
    _TaskManagerScreenState createState() => _TaskManagerScreenState();
}

class _TaskManagerScreenState extends State<TaskManagerScreen> {
    final List<Task> tasks = [
        Task(title: "Buy groceries"),
    Task(title: "Complete Flutter project"),
    Task(title: "Workout"),
    Task(title: "Call mom"),
    ];

    void toggleTaskStatus(int index) {
        setState(() {
            tasks[index].isCompleted = !tasks[index].isCompleted;
        });
    }

    @override
    Widget build(BuildContext context) {
        return Scaffold(
            appBar: AppBar(
                    title: Text('Task Manager'),
        ),
        body: ListView.builder(
        itemCount: tasks.length,
        itemBuilder: (context, index) {
        final task = tasks[index];
        return ListTile(
            title: Text(
                    task.title,
            style: TextStyle(
                    decoration: task.isCompleted
        ? TextDecoration.lineThrough
        : TextDecoration.none,
        ),
        ),
        trailing: IconButton(
        icon: Icon(
        task.isCompleted ? Icons.check_box : Icons.check_box_outline_blank,
        color: task.isCompleted ? Colors.green : null,
        ),
        onPressed: () => toggleTaskStatus(index),
        ),
        );
    },
        ),
        );
    }
}

class Task {
    final String title;
    bool isCompleted;

    Task({required this.title, this.isCompleted = false});
}
