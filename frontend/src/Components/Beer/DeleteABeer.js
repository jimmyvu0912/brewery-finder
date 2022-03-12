//Doesn't actually delete a beer, just sets the status to inactive

import axios from "axios";
import { useState } from "react";
import { baseUrl } from "../../Shared/baseUrl";

const DeleteABeer = (props) => {
  const [isActive, setIsActive] = useState(false);

  const handleChange = () => {
    const data = { isActive: isActive };
    setChecked(!checked);
    axios.delete(baseUrl + "/beers/{beerId}", data);
  };

  return (
    <div>
      <label>
        <input type="checkbox" checked={checked} onChange={(e) => setIsActive(e.target.value)} />
        Change Status of Beer
      </label>
    </div>
  );
};

export default withRouter(connect(mapDispatchToProps)(DeleteABeer));
