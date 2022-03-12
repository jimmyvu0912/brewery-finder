import * as ActionTypes from "./actionTypes";

export const Beer = (
  state = {
    id: null,
    name: "",
    abv: "",
    type: "",
    info: "",
    beer_image_url: "",
    authorities: [],
  },
  action
) => {
  switch (action.type) {
    case ActionTypes.ADD_BEER:
      return {
        ...state,
        id: action.payload.id,
        name: action.payload.name,
        abv: action.payload.abv,
        type: action.payload.type,
        info: action.payload.info,
        beer_image_url: action.payload.beer_image_url,
        authorities: action.payload.authorities,
      };

    case ActionTypes.DELETE_BEER:
      return {
        ...state,
        id: action.payload.id,
        name: action.payload.name,
        abv: action.payload.abv,
        type: action.payload.type,
        info: action.payload.info,
        beer_image_url: action.payload.beer_image_url,
        authorities: action.payload.authorities,
      };

    default:
      return state;
  }
};
