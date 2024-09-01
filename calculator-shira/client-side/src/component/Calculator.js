import React, { useState } from "react";
import "./Calculator.css";
import {CalculateMe} from "../services/connectToServer";

export const Calculator = () => {
  const [input, setInput] = useState("");
  const [result, setResult] = useState("");
  const arrOperations=['1','2','3','+','4','5','6','-','7','8','9','*','.','/','='];
  
  const handleClick=(char)=>{
    setInput(String(input+char));
  }

  const handleClear=()=>{
    setInput("");
    setResult("");
  }

  const calculate=async()=>{
    try{
      await CalculateMe(input).then((response)=>{
      setResult(response.data);
    })}
    catch(error){
      throw new error("Error", error);
    }
  }

  return (
    <div className="calculator">
      <div className="calculator-display">
        <div className="input">{input}</div>
        <div className="result">{result}</div>
      </div>
      <div className="calculator-buttons">
       { 
         arrOperations.map(item=><button key={item} 
          onClick={() =>item=='='?calculate(): handleClick(item)}>{item}</button>)
       }
        <button onClick={()=>handleClear()} >C</button>
      </div>
    </div>
  );
};
