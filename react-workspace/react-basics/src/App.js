import logo from './logo.svg';
import './App.css';
import Welcome from './components/Welcome';

function App() {
  return (
    <div className="App">
      <Welcome name="Ken" />
      <Welcome name="Nat" />
    </div>
  );
}

export default App;
