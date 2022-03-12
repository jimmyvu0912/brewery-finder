import axios from "axios";
import { useState } from "react";
import { baseUrl } from "../../Shared/baseUrl";

const AddABeer = (props) => {
  const [name, setName] = useState("");
  const [city, setCity] = useState("");
  const [state, setState] = useState("");
  const [breweryLogoURL, setBreweryLogoURL] = useState("");
  const [websiteURL, setWebsiteURL] = useState("");

  const handleSubmit = () => {
    const data = {
      name: name,
      city: city,
      state: state,
      breweryLogoURL: breweryLogoURL,
      websiteURL: websiteURL,
    };
    axios.post(baseUrl + "/reviews", data);
  };

  return (
    <div>
      <h1>Add a Brewery</h1>
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
      <label class="sr-only">City</label>
      <input
        type="text"
        id="city"
        name="city"
        class="form-control"
        placeholder="City"
        v-model="brewery.city"
        onChange={(e) => setCity(e.target.value)}
        required
      />
      <label class="sr-only">State</label>
      <input
        type="text"
        id="state"
        name="state"
        class="form-control"
        placeholder="State"
        v-model="brewery.state"
        onChange={(e) => setState(e.target.value)}
        required
      />
      <label class="sr-only">Logo Url</label>
      <input
        type="text"
        id="breweryLogoURL"
        name="breweryLogoURL"
        class="form-control"
        placeholder="Paste your logo's URL"
        v-model="brewery.breweryLogoURL"
        onChange={(e) => setBreweryLogoURL(e.target.value)}
        required
      />
      <label class="sr-only">Website Url</label>
      <input
        type="text"
        id="websiteURL"
        name="websiteURL"
        class="form-control"
        placeholder="Paste your website's URL"
        v-model="brewery.websiteURL"
        onChange={(e) => setWebsiteURL(e.target.value)}
        required
      />
      <button type="submit" onClick={this.handleSubmit}>
        Submit
      </button>
    </div>
  );
};

export default withRouter(connect(mapDispatchToProps)(AddABrewery));
