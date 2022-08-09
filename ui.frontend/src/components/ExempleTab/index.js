import React from "react";
import { MapTo } from "@adobe/aem-react-editable-components";

const Exemple = ({ exempleOne, exempleTwo }) => {
  return (
    <>
      {exempleOne.map(({ textOne, imageComponent = {} }, index) => (
        <div key={index}>
          <img src={imageComponent.src} />
          <p>{textOne}</p>
        </div>
      ))}
      {exempleTwo.map(({ title, titleTwo }, index) => (
        <div key={index}>
          <h1>{title}</h1>
          <h2>{titleTwo}</h2>
        </div>
      ))}
    </>
  );
};

Exemple.defaultProps = {
  exempleOne: [
    {
      imageComponent: {
        src: "https://via.placeholder.com/150",
      },
      textOne: "Digite aqui uma descrição",
    },
  ],
  exempleTwo: [
    {
      title: "Digite aqui um titulo",
      titleTwo: "Digite aqui um subtítulo",
    },
  ],
};

export default MapTo("reactapp/components/tabs-exemple")(Exemple);
