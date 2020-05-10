import React, { useState, useEffect } from 'react'
import blogService from './services/blogService'

import './App.css';

function App() {
  const [blogs, setBlogs] = useState([])
  const [title, setTitle] = useState('')
  const [author, setAuthor] = useState('')
  const [url, setUrl] = useState('')

  useEffect(() => {
    blogService.getAll().then(
      blogs => setBlogs(blogs)
    )
  },[])

  const handleSubmit = () => {
    const newBlog = {
      title: title,
      author: author,
      url: url,
      likes: 0
    }
    blogService.addBlog(newBlog).then(console.log('added blog successfully'))
  }

  const Blog = ({blog}) => {

    const handleDelete = () => {
      blogService.removeBlog(blog.id).then(setBlogs(blogs.filter(b => b.id !== blog.id)))
    }

    const handleLikes = () => {
      const updatedBlog =  {
        ...blog,
        likes: blog.likes + 1
      }
      blogService
        .updateBlog(blog.id, updatedBlog)
        .then(setBlogs(blogs.map(b => b.id === blog.id ? updatedBlog : b)))
    }

    return (
      <div class="blogs">
        title: {blog.title}
        <br/>
        author: {blog.author}
        <br/>
        url: {blog.url}
        <br/>
        likes: {blog.likes} <button onClick={handleLikes}>like</button>
        <br/>
        <button onClick={handleDelete}>delete</button>
      </div>
    )
  }

  return (
    <div>
      <h2>Create Blog</h2>
      <form onSubmit={handleSubmit}>
        <div>
          title: <input value={title} onChange={({target}) => setTitle(target.value)}></input>
        </div>
        <div>
          author: <input value={author} onChange={({target}) => setAuthor(target.value)}></input>
        </div>
        <div>
          url: <input value={url} onChange={({target}) => setUrl(target.value)}></input>
        </div>
        <button>add</button>
      </form>
      <br/>
      {blogs.map((blog, i) => 
        <Blog key={i} blog={blog}/>
      )}
    </div>
  );
}

export default App;
