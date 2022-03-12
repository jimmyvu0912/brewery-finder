import axios from "axios";
import { useState } from "react";
import { baseUrl } from "../../Shared/baseUrl";

const AddABeer = (props) => {
  const [name, setName] = useState("");
  const [abv, setAbv] = useState("");
  const [type, setType] = useState("");
  const [info, setInfo] = useState("");

  const handleSubmit = () => {
    const data = { name: name, abv: abv, type: type, info: info, beer_image_url: beer_image_url };
      axios.post(baseUrl + "/reviews", data);
  };

  return (
    <div>
      <h1>Add a Beer</h1>
      <label class="sr-only">Name</label>
      <input
        type="text"
        id="name"
        name="name"
        class="form-control"
        placeholder="Name"
        v-model="beer.name"
        onChange={(e) => setName(e.target.value)}
        required
      />
      <label class="sr-only">Abv</label>
      <input
        type="text"
        id="abv"
        name="abv"
        class="form-control"
        placeholder="abv"
        v-model="beer.abv"
        onChange={(e) => setAbv(e.target.value)}
        required
      />
      <label class="sr-only">Type</label>
      <input
        type="text"
        id="type"
        name="type"
        class="form-control"
        placeholder="Type"
        v-model="beer.type"
        onChange={(e) => setType(e.target.value)}
        required
      />

      <label class="sr-only">
        Beer Description
        <textarea value={this.rating.value} onChange={(e) => setInfo(e.target.value)} />
      </label>
      <input
        type="text"
        id="info"
        name="info"
        class="form-control"
        placeholder="info"
        v-model="beer.info"
        onChange={(e) => setInfo(e.target.value)}
        required
      />
      <button type="submit" onClick={this.handleSubmit}>
        Submit
      </button>
    </div>
  );
};

export default withRouter(connect(mapDispatchToProps)(AddABeer));
