import React, {useState} from 'react';

const App: React.FC = () => {
  const [todo, setTodo] = useState<string>("");

  return (
    <div>
      <h1>Hello Dear!</h1>
    </div>
  );
}

export default App;
