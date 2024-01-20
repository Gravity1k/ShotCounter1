<!-- BlogDetail.vue -->
<template>
    <AppHeader></AppHeader>
    <div>
      <h1>{{ blogPost.title }}</h1>
      <p>{{ blogPost.content }}</p>
      <!-- ... other details ... -->
    </div>
  </template>
  
  <script>
  export default {
    name: 'BlogDetail',
    data() {
      return {
        blogPost: {},
      };
    },
    created() {
      // Fetch the blog post based on the ID from route parameters
      const postId = this.$route.params.id;
      // For simplicity, let's use a static object as an example
      this.blogPost = {
        title: `Blog Post ${postId}`,
        content: `Content of Blog Post ${postId}`,
      };
    },
  };
  </script>