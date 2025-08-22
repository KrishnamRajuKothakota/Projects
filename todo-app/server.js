const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');
const path = require('path');

const app = express();
const PORT = 3000;
const FILE_PATH = path.join(__dirname, 'todos.txt');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.json());
app.use(express.static('public'));

// Helper to read todos from file
function getTodos() {
  if (!fs.existsSync(FILE_PATH)) return [];
  const data = fs.readFileSync(FILE_PATH, 'utf8');
  return data
    .split('\n')
    .filter(line => line.trim() !== '');
}

// Helper to write todos to file
function saveTodos(todos) {
  fs.writeFileSync(FILE_PATH, todos.join('\n'), 'utf8');
}

// Serve existing todos
app.get('/todos', (req, res) => {
  const todos = getTodos();
  res.json(todos);
});

// Add a new todo
app.post('/add', (req, res) => {
  const { task } = req.body;
  if (task && task.trim() !== '') {
    const todos = getTodos();
    todos.push(task.trim());
    saveTodos(todos);
    res.json({ success: true });
  } else {
    res.status(400).json({ error: 'Task cannot be empty.' });
  }
});

// Delete a todo by index
app.post('/delete', (req, res) => {
  const { index } = req.body;
  let todos = getTodos();
  if (index >= 0 && index < todos.length) {
    todos.splice(index, 1);
    saveTodos(todos);
    res.json({ success: true });
  } else {
    res.status(400).json({ error: 'Invalid index.' });
  }
});

app.listen(PORT, () => {
  console.log(`📝 To-Do App running at http://localhost:${PORT}`);
});
