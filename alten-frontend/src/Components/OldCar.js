import React, {useState, useEffect} from 'react';
import axios from 'axios';

export default function Car(){

  const [carList, setCarList] = useState([]);
  const [loading, setLoading] = useState(true);
  const [uniques, setUniques] = useState([])
  const [search, setSearch] = useState({
    parked: null
  }) 

  const filter = () => {
    console.log(search)

    axios.post("http://localhost:8080/searchCar", search)
      .then(res => setCarList(res.data))
      console.log(carList);
  }

  useEffect(() => {
    axios.get("http://localhost:8080/getCars")
    .then(res => {
      setCarList(res.data)
      setUniques(res.data)})
    .then(setLoading(false))
  }, []);

  if(!loading)
  return(
    <div>


      <select name="parked" onChange={e => { setSearch(search, search.parked=e.target.value);filter();}}>
        <option value={true}>true</option>
        <option value={false}>false</option>
      </select>

      <ul>
      {carList.map(c => 
        <li key={c.id}> {c.regNr + ' | ' + c.parked }
        </li>
      )}
    </ul>
    
    </div>
  )
  else{
    return(
      <div>
        <h1>Loading carlist...</h1>
      </div>
    )
  }

}