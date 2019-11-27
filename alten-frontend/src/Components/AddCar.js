import React, {useState} from 'react';
import axios from 'axios';

export default function AddCar (props){
  
  const [car, setCar] = useState({
    vehicleId: null,
    regNr: null,
    parked: null
  });

  const handleSubmit = event => {
    let carlist = props.carList
    event.preventDefault();
    axios.post('http://localhost:8080/addCar', car)
      .then(res => props.setCarList(carlist = [...carlist, car])
      )
      console.log(carlist.parked)
  };

  return(
    <form onSubmit={handleSubmit}>
      <label>
        Car reg:
        <input type="text" name="regNr" onChange={e => setCar(car, car.regNr=e.target.value)} />
      </label>
      <label>
        Car vehicleId:
        <input type="text" name="vehicleId" onChange={e => setCar(car, car.vehicleId=e.target.value)} />
      </label>
      <label> 
        Car parked
        <input type="text" name="parked" onChange={e => setCar(car, car.parked=e.target.value)} />
      </label>
      <button type="submit">Add button</button>
    </form>
  )
}

/* 

*/