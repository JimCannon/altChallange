import React, {useState, useEffect} from 'react';

import CarList from './CarList';

export default function Companies(props){
    console.log(props); 
    return(
        <ul>
            {props.companyList.map(c =>
            <li key={c.id}> {
                    c.companyName
                }
                <ul>
                    {
                        c.carList.map(cars => <li key={c.id}>{cars.regNr}</li>)
                    }
                </ul>
            </li>
            )}
        </ul>
    )
}