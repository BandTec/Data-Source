import React, { Component } from 'react';
import { Bar, Line, Pie } from 'react-chartjs-2';


const LineChart = () => {

  let data = {
    labels: ['Usuários', 'Usuários'],
    datasets: [{
      data: [1, 3, 0, 1],

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
  }

  return (
    <>
      <Line
        data={data}
        options={{
          title: {
            display: true,
            text: 'Usuáros no servidor'
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
      />
    </>
  )
}


export default LineChart;
