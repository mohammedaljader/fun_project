import React, {useState} from 'react'
import './task.css';
import { useDrag } from "react-dnd";


interface props {
    task_title: string;
    task_id: string;
    card_id: string;
    task_completed: boolean;
    updateTaskTitle: (taskId: string, newName : string) => void;
    deleteTask: (taskId: string) => void;
    strikeTask:  (taskId: string) => void;
  }

const Task : React.FC<props> =({
    task_title, task_id, task_completed, card_id,
    updateTaskTitle, deleteTask, strikeTask
}) =>
{
    const [newTaskTitle, setNewTaskTitle] = useState<string>("");
    const [taskTitleChangeBool, setTaskTitleChangeBool] = useState<boolean>(false);

    const [isCompleted, setIsCompleted] = useState<boolean>(task_completed);

    const [{ isDragging }, drag] = useDrag(() => ({ // eslint-disable-line
        type: "div",
        item: { 
            taskId: task_id,
            taskTitle: task_title,
            taskStatus: task_completed
        },
        collect: (monitor) => ({
          isDragging: !!monitor.isDragging(),
        }),
      }));

    const handleUpdateSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        if (newTaskTitle === ''){
            return;
        }
        else{
           updateTaskTitle(task_id, newTaskTitle);
           setNewTaskTitle('');
           setTaskTitleChangeBool(!taskTitleChangeBool);
        }
    }

    const handleStrike = () => {
        strikeTask(task_id);
        setIsCompleted(!isCompleted);
    }
    
    return (
        <>
        <div className="task" ref={drag}>
            {taskTitleChangeBool
                ?
                   <form className="update-form" onSubmit={event => handleUpdateSubmit(event)}>
                        <input 
                            className="update-task" 
                            type="text" 
                            placeholder={task_title}
                            onChange={event => setNewTaskTitle(event.target.value)}
                        />
                    </form>
                :
                    <>
                        <p 
                            onClick={() => handleStrike()}
                            className="title"
                            style={isCompleted ? {textDecoration: 'line-through', textDecorationWidth: '10px', textDecorationThickness: '2px', fontStyle: 'italic'} : {textDecoration: 'none'}}> 
                            {task_title} 
                        </p>
                    </>
             }     
            
            <div className="buttons">
                <button 
                    className="edit-task"
                    onClick={() => setTaskTitleChangeBool(!taskTitleChangeBool)}
                >
                </button>

                <button
                    className="delete"
                    onClick={() => deleteTask(task_id)}
                >X</button>
            </div>
        </div>
        </>

    )
}

export default Task;