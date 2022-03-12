import axios from "axios";
import { useState } from "react";
import { baseUrl } from "../../Shared/baseUrl";

const Review = (props) => {
  const [name, setName] = useState("");
  const [review, setReview] = useState("");
  const [rating, setRating] = useState("");

  const handleSubmit = () => {
    const data = { name: name, review: review, rating: rating };
      axios.post(baseUrl + "/reviews", data);
  };

  return (
    <div>
      <h1>Leave a Review</h1>
      <label class="sr-only">Title</label>
      <input
        type="text"
        id="name"
        name="name"
        class="form-control"
        placeholder="Title"
        v-model="review.name"
        onChange={(e) => setName(e.target.value)}
        required
      />
      <label class="sr-only">
        Review
        <textarea value={this.rating.value} onChange={(e) => setReview(e.target.value)} />
      </label>
      <input
        type="text"
        id="description"
        name="description"
        class="form-control"
        placeholder="description"
        v-model="review.description"
        onChange={(e) => setReview(e.target.value)}
        required
      />
      <label class="sr-only">
        Rating
        <select value={this.rating.value} onChange={(e) => setRating(e.target.value)}>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
      </label>

      <button type="submit" onClick={this.handleSubmit}>
        Submit
      </button>
    </div>
  );
};

export default withRouter(connect(mapDispatchToProps)(Review));
