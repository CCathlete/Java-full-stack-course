import React from 'react';
import logo from './logo.svg';
import './App.css';
import Welcome from './components/Welcome';
import { Greeting } from './components/Greeting';
import { Student, StudentProps } from './components/Student';
import { Employee } from './components/Employee';
import { User, UserProps } from './components/User';

function App()
{
  const data: StudentProps = {
    name: 'Bebe',
    age: 20,
    email: 'bebebebe@example.com',
  };
  const userData: Object = {
    firstName: 'First',
    lastName: 'Last',
    email: 'Email',
  };
  return (
    <div className="App">
      <header className="App-header">
        <Welcome name='Bubu' />
        <Greeting name='Biboo' />
        <Student
          { ...data }
        />
        <Employee
          { ...data } position='Developer'
        />
        <User { ...userData as UserProps } />
        <img src={ logo } className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
