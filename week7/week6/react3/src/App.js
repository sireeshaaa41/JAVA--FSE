import React from 'react';
import './App.css'; // Keep the default App.css if you wish, or remove if not used
import CalculateScore from './Components/CalculateScore'; // Import your component

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Student Score Calculator</h1>
      </header>
      <main>
        {/* Render the CalculateScore component with sample data */}
        <CalculateScore
          Name="Alice Smith"
          School="Greenwood High"
          Total={85}
          Goal={100}
        />

        <CalculateScore
          Name="Bob Johnson"
          School="Riverdale Academy"
          Total={72}
          Goal={90}
        />

        <CalculateScore
          Name="Charlie Brown"
          School="Peach Tree Elementary"
          Total={95}
          Goal={100}
        />
      </main>
    </div>
  );
}

export default App;
