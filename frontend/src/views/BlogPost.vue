<template>
  <div>
    <app-header></app-header>

    <!-- Blog Card 1 -->
    <router-link :to="{ name: 'blogDetail', params: { id: 1 } }" class="blog-link">
      <div class="blog-card">
        <div class="meta">
          <div class="photo1"></div>
        </div>
        <div class="description">
          <h1>Learning to Code</h1>
          <h2>Opening a door to the future</h2>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad eum dolorum architecto obcaecati enim dicta
            praesentium, quam nobis! Neque ad aliquam facilis numquam. Veritatis, sit.
          </p>
          <p class="read-more">
            <a href="#">Read More</a>
          </p>
        </div>
      </div>
    </router-link>

    <!-- Blog Card 2 -->
    <router-link :to="{ name: 'blogDetail', params: { id: 2 } }" class="blog-link">
      <div class="blog-card alt">
        <div class="meta">
          <div class="photo2"></div>
        </div>
        <div class="description">
          <h1>Lorem ipsum dolor sit amet</h1>
          <h2>Lorem ipsum dolor sit amet</h2>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad eum dolorum architecto obcaecati enim dicta
            praesentium, quam nobis! Neque ad aliquam facilis numquam. Veritatis, sit.
          </p>
          <p class="read-more">
            <a href="#">Read More</a>
          </p>
        </div>
      </div>
    </router-link>
  </div>
</template>

<script>
import AppHeader from './AppHeader.vue';

export default {
  components: { AppHeader },
  name: 'BlogPost',
};
</script>

<style>

* {
  box-sizing: border-box;
}

.blog-card {
  display: flex;
  flex-direction: column;
  margin: 4rem auto;
  box-shadow: 0 3px 7px -1px rgba(0, 0, 0, 0.1);
  margin-bottom: 1.6%;
  background: #ffffff;
  line-height: 1.4;
  font-family: sans-serif;
  border-radius: 5px;
  overflow: hidden;
  z-index: 0;
}

.blog-card a {
  color: inherit;
}

.blog-card a:hover {
  color: #5a77d6;
}

.blog-card .meta {
  position: relative;
  z-index: 0;
  height: 200px;
}

.blog-card .details,
.blog-card .details ul {
  margin: auto;
  padding: 0;
  list-style: none;
}

.blog-card .details {
  position: absolute;
  top: 0;
  bottom: 0;
  left: -100%;
  margin: auto;
  transition: left 0.2s;
  background: rgba(0, 0, 0, 0.6);
  color: #000000;
  padding: 10px;
  width: 100%;
  font-size: 0.9rem;
}

.blog-card .details a {
  text-decoration: dotted underline;
}

.blog-card .details ul li {
  display: inline-block;
}

.blog-card .details .author:before,
.blog-card .details .date:before {
  font-family: FontAwesome;
  margin-right: 10px;
}

.blog-card .details .author:before {
  content: "\f007";
}

.blog-card .details .date:before {
  content: "\f133";
}

.blog-card .details .tags ul:before {
  font-family: FontAwesome;
  content: "\f02b";
  margin-right: 10px;
}

.blog-card .details .tags li {
  margin-right: 2px;
}

.blog-card .details .tags li:first-child {
  margin-left: -4px;
}

.blog-card .description {
  padding: 1rem;
  background: #ffffff;
  position: relative;
  z-index: 1;
}

.blog-card .description h1,
.blog-card .description h2 {
  font-family: Poppins, sans-serif;
}

.blog-card .description h1 {
  line-height: 1;
  margin: 0;
  font-size: 1.7rem;
}

.blog-card .description h2 {
  font-size: 1rem;
  font-weight: 300;
  text-transform: uppercase;
  color: #a2a2a2;
  margin-top: 5px;
}

.blog-card .description .read-more {
  text-align: right;
}

.blog-card .description .read-more a {
  color: #3183b9;
  display: inline-block;
  position: relative;
}

.blog-card .description .read-more a:after {
  content: "\f061";
  font-family: FontAwesome;
  margin-left: -10px;
  opacity: 0;
  vertical-align: middle;
  transition: margin 0.3s, opacity 0.3s;
}

.blog-card .description .read-more a:hover:after {
  margin-left: 5px;
  opacity: 1;
}

.blog-card p {
  position: relative;
  margin: 1rem 0 0;
}

.blog-card p:first-of-type:before {
  content: "";
  position: absolute;
  height: 5px;
  background: #3981d3;
  width: 35px;
  top: -0.75rem;
  border-radius: 3px;
  transition: width 1.3s;
}

.blog-card:hover p:first-of-type:before {
  width: 180px; /* Adjust the width on hover */
}

.blog-card:hover .details {
  left: 0%;
}

@media (min-width: 640px) {
  .blog-card {
    flex-direction: row;
    max-width: 700px;
  }

  .blog-card .meta {
    flex-basis: 40%;
    height: auto;
  }

  .blog-card .description {
    flex-basis: 60%;
  }

  .blog-card .description:before {
    transform: skewX(-3deg);
    content: "";
    background: #ffffff;
    width: 30px;
    position: absolute;
    left: -10px;
    top: 0;
    bottom: 0;
    z-index: -1;
  }

  .blog-card.alt {
    flex-direction: row-reverse;
  }

  .blog-card.alt .description:before {
    left: inherit;
    right: -10px;
    transform: skew(3deg);
  }

  .blog-card.alt .details {
    padding-left: 25px;
  }
}

.blog-card.alt .meta .photo2,
.blog-card .meta .photo1 {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background-size: cover;
  background-position: center;
  transition: transform 1.3s;
}

.blog-card.alt .meta .photo2 {
  background-image: url('../pictures/Blog2.jpg');
}

.blog-card .meta .photo1 {
  background-image: url('../pictures/Blog1.png');
}

.blog-card:hover .meta .photo1 {
  transform: scale(1.3) rotate(3deg);
}

.blog-card.alt:hover .meta .photo2 {
  transform: scale(1.3) rotate(3deg);
}

.blog-card:hover .description h1,
.blog-card:hover .description p {
  color: #000000;
}

.blog-link {
  width: fit-content;
  height: fit-content;
  text-decoration: none;
  display: flex;
  flex-direction: column;
  margin: 4rem auto;
  height: fit-content;
  padding: 0; /* Add this line to set padding to 0 */
  align-items: center; /* Add this line to center the content horizontally */
}

</style>