import React, {useState} from 'react';
import './card.css';
import Task from './Task';
import { useDrop } from "react-dnd";
import { task } from '../Models/Task';


interface props {
    card_title: string;
    taskList: task[];
    card_id: string;
    updateCardTitle: (cardId : string, newName : string) => void;
    deleteCard: (cardId : string) => void;
    updateTaskTitle: (taskId: string, newName : string) => void;
    addTask: (cardId: string, addedTitle : string) => void;
    deleteTask: (taskId: string) => void;
    strikeTask:  (taskId: string) => void;
    updateNewCard: (taskId: string, cardId: string) => void;
  }


const Card : React.FC<props> = ({
    card_title, taskList, card_id,
    updateCardTitle, deleteCard,
    updateTaskTitle, addTask, deleteTask, strikeTask, updateNewCard
}) =>
{
    const [newCardTitle, setNewCardTitle] = useState('');
    const [cardTitleChangeBool, setCardTitleChangeBool] = useState(false);
    const [addTaskTitle, setAddTaskTitle] = useState('')
    // const [Tasks, setTasks] = useState([])

    const [{ isOver }, drop] = useDrop(() => ({ // eslint-disable-line
        accept: "div",
        drop: (item: task) => updateNewCard(item.taskId ,card_id),
        collect: (monitor) => ({
          isOver: !!monitor.isOver(),
        }),
      }), [taskList]);

    const handleUpdateSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        if (newCardTitle === ''){
            return;
        }
        else{
           updateCardTitle(card_id, newCardTitle)
           setCardTitleChangeBool(!cardTitleChangeBool)
           setNewCardTitle('')
        }
    }

    const handleAddSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        if (addTaskTitle === ''){
            return;
        }
        else{
           addTask(card_id, addTaskTitle);
           setAddTaskTitle('');
        }
    }

   

    return (
        <div className="card" ref={drop} >
            <div className="title-div">
                {cardTitleChangeBool
                    ?
                        <form action="" onSubmit={event => handleUpdateSubmit(event)}>
                                <input 
                                    onChange={event => setNewCardTitle(event.target.value)}
                                    className="update-title" 
                                    type="text"
                                    placeholder={card_title}
                                />
                        </form>      
                    :
                        <h3 onClick={() => setCardTitleChangeBool(!cardTitleChangeBool)}>
                            {card_title}
                        </h3>  
                }  
            </div>

            {taskList.map(curr => (
                <Task 
                    key={curr.taskId}

                    // Task Properties
                    task_title={curr.taskTitle}
                    task_id={curr.taskId}
                    task_completed={curr.taskStatus}
                    card_id={card_id}
                    
                     // Task Functions
                     updateTaskTitle={updateTaskTitle}
                     deleteTask={deleteTask}
                     strikeTask={strikeTask}
                />
            ))}

            <form className="add-task" action="input" onSubmit={event => handleAddSubmit(event)}>
                <input type="text" placeholder="Add Task" value={addTaskTitle} onChange={event => setAddTaskTitle(event.target.value)}/> 
                <button className="add-btn" >+</button>  
            </form>
            
            <button className="delete-card" onClick={() => deleteCard(card_id)}>Delete</button>
        </div>
    )
}

export default Card;