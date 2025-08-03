import React from 'react';
import './App.css'; // Assuming you still want to keep App.css
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        {/* You can remove or modify the default React logo and text here */}
        <h1>Student Management Portal</h1>
      </header>
      <main>
        <Home />
        <About />
        <Contact />
      </main>
    </div>
  );
}

export default App;
