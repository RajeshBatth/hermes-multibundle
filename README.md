# hermes-multibundle


This project is to test loading multiple bundles on hermes in a single context

Here we load default bundle first and then load the second bundle from file-system after some timeout

JS
```
    importLazy("pages/home/index.js").then(homeModule => {
      
    })
```

Bundle
```
    node runBundle.js
```

