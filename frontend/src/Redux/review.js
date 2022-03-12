import * as ActionTypes from "./actionTypes";

export const Review = (
  state = {
    id: null,
    name: "",
    description: "",
    rating: "",
    authorities: [],
  },
  action
) => {
  switch (action.type) {
    case ActionTypes.ADD_REVIEW:
      return {
        ...state,
        id: action.payload.id,
        name: action.payload.name,
        description: action.payload.description,
        rating: action.payload.rating,
        authorities: action.payload.authorities,
      };

    default:
      return state;
  }
};
