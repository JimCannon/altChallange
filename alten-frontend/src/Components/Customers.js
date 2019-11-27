import React, {useState, useEffect} from 'react';
import axios from 'axios';
import { Jumbotron, Button } from 'react-bootstrap';
import Company from './Company';

import { Fragment } from 'react';

export default function Customers(){

  const [companyList, setCompanyList] = useState([]);
  const [uniques, setUniques] = useState([])
  const [loading, setloading] = useState(true);
  const [search, setSearch] = useState({
    companyName: null
  })

  const filter = () => {
    
    if(search.companyName==="Alla") setSearch(search, search.companyName = null)
    axios.post("http://localhost:8080/searchCompanies/", search)
      .then(res => setCompanyList(res.data))
  }

  useEffect(() => {
    axios.get("http://localhost:8080/getAllCompanies")
      .then(res => {
        setCompanyList(res.data)
        setUniques(res.data)})
      .then(setloading(false))
  }, []);
  
  if(!loading){
  return(
      <Jumbotron>
        <h1>Hello, world!</h1>
        <p>
          Slappa da bass
        </p>
      
      <div>
        <select name="company" onChange={e => { setSearch(search, search.companyName=e.target.value);filter();}}>
            <option key={null} value={null}>Alla</option>
            {Array.from(new Set(uniques.map(x => x.companyName))).map(type => 
              <option key={type}>{type}</option>
            )}
        </select>  
      </div>
      {companyList.map(c => 
        <Company key={c.id}company={c} />
      )}
      </Jumbotron>
  ) 
}
  else{
    return(
      <div>
        <h1>Loading companies...</h1>
      </div>
    )
  }
}