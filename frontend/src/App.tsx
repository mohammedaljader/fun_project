import React from 'react';
import { DndProvider } from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";


// Page Components
import Trello from './trello';

// CSS Imports
import './App.css';
import './Components/card.css';


const App: React.FC = () => {

  return (
    <DndProvider backend={HTML5Backend}>
        <Trello/>
    </DndProvider>
  );
}

export default App;
