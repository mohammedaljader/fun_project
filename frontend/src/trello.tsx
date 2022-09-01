// Packages
import React, {useState} from 'react';
import { v4 as uuidv4 } from 'uuid';

// Child Components
import Navbar from './Components/Navbar';
import Card from './Components/Card';

// CSS Imports
import './App.css';
import './Components/card.css';
import { card } from './Models/Card';
import { task } from './Models/Task';



function Trello() {
  const [cards, setCards] = useState<card[]>([]);
  const [tasks, setTasks] = useState<task[]>([]);

    
    //Card functionalities 
    const addCard = () => {
      setCards([...cards, {cardId: uuidv4(), cardName: "New Card (Update)"}]);
    }

    const updateCardTitle = (cardId : string, newName : string) => {
      let edit = cards.slice();
      edit.forEach(currCard => {
        if (currCard.cardId === cardId){
          console.log(currCard.cardName)
          currCard.cardName = newName;
        }
      })
      setCards(edit);
    }

    const deleteCard = (cardId : string) => {
      setTasks(tasks.filter(currTask => currTask.cardId !== cardId));
      setCards(cards.filter(currCard => currCard.cardId !== cardId));
    }

     //Task functionalities 
     const addTask = (cardId: string, addedTitle : string) => {  

        setTasks([...tasks, {taskId: uuidv4(), taskTitle: addedTitle, taskStatus: false, cardId: cardId }]);
    }

    const updateTaskTitle = (taskId: string, newName : string) => {
      let edit = tasks.slice();
      edit.forEach(currTask => {
        if (currTask.taskId === taskId){
          currTask.taskTitle = newName
        }
      })
      setTasks(edit);
  
    }

    const deleteTask = (taskId: string) => {
      setTasks(tasks.filter(currTask => currTask.taskId !== taskId));
    }

    const strikeTask = (taskId: string) => {
      let edit = tasks.slice();
      edit.forEach(currTask => {
        if (currTask.taskId === taskId){
          let isStruck = currTask.taskStatus;
          currTask.taskStatus = !isStruck;
        }
      })
      setTasks(edit);
    }

    const updateNewCard = (taskId: string, cardId: string) => {
      let edit = tasks.slice();
      edit.forEach(currTask => {
        if (currTask.taskId === taskId){
            currTask.cardId= cardId;
        }
      })

      setTasks(edit);
    };

  return (
    <>
    <Navbar /> 
    <div className="contain">
      {/* CARDS */}
      {cards.map(currCard => (
        <Card
          key={currCard.cardId}
          card_title={currCard.cardName}
          taskList={tasks.filter(curr => curr.cardId === currCard.cardId)}
          card_id={currCard.cardId}
          
           // Card Functions
           updateCardTitle={updateCardTitle}
           deleteCard={deleteCard}

           // Task Functions
           updateTaskTitle={updateTaskTitle}
           addTask={addTask}
           deleteTask={deleteTask}
           strikeTask={strikeTask}
           updateNewCard={updateNewCard}
        />
      ))}

      {/* NEW CARD */}
      <button className="new-list" onClick={() => addCard()}>+</button>
      <div className="padding-div"></div>
    </div>
    </>
  );
}

export default Trello;