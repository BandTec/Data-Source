import React, { useState, useEffect } from 'react';
import {  Line  } from 'react-chartjs-2';


const LineChart = ({dados, componenteEscolhido}) => {

  
  const [dataState, setDataState] = useState({
    labels: [],
    datasets: [{
      data: [],

      backgroundColor: [
        '#1B2A47',

      ],
      hoverBackgroundColor: [
        '#4e73df',
      ],
      borderColor: [
        '#4e73df',
      ],

    }]
  });

  // let dados = {
  //   labels: [],
  //   datasets: [{
  //     data: [],

  //     backgroundColor: [
  //       '#1B2A47',

  //     ],
  //     hoverBackgroundColor: [
  //       '#4e73df',
  //     ],
  //     borderColor: [
  //       '#4e73df',
  //     ],

  //   }]
  // }

  // useEffect(() => {
    async function a() {
      dataState.datasets[0].data = [];
      dataState.labels = [];
      await dados.map((item)=> {
        dataState.labels.push(item.CODA_DH_COLETA.substring(11));
        switch (componenteEscolhido) {
          case "CPU":
            dataState.datasets[0].data.push(item.CODA_USO_CPU.replace(' %', ''));
            break;
          case "MEM":
            dataState.datasets[0].data.push(item.CODA_USO_MEM_RAM.replace(' %', ''));
            break;
          case "HD":
            dataState.datasets[0].data.push(item.CODA_USO_DISCO.replace(' %', ''));
            break;
        }
      });
    
      
    
      console.log(dataState.datasets[0].data)

      // console.log(dataState.labels);
      // console.log(dataState.datasets[0].data);
    }
  
    a();

  // }, []);

  

  return (
    <>
      {dataState.labels && <Line
        data={dataState}
        options={{
          title: {
            display: true,
            text: 'Dados do hardware'
          },
          legend: {
            display: false
          },
          layout: {
            padding: {
              left: 10,
              right: 25,
              top: 25,
              bottom: 0
            }
          },
          responsive: true,
          maintainAspectRatio: false,
          hoverMode: 'index',
          stacked: false,

        }}
        
      />}
    </>
  )
}


export default LineChart;
