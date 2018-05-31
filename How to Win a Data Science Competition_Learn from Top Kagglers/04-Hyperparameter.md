# Hyperparameter optimization
---
## Hyperparameters tuning
### Models
#### Tree-based models
- GBDT: XGBoost, LightGBM, CatBoost
- RandomForest/ExtraTrees
#### Neural nets
- Pytorch, Tensorflow, Keras...
#### Linear models
- SVM, logistic regression
- Vowpal Wabbit, FTRL
#### Factorization Machines (out of scope)
- libFM, libFFM

### How do we tune hyperparameters?
#### 1. Select the most influential parameters
- There are tons of parameters and we can’t tune all of them.
#### 2. Understand, how exactly they influence the training
#### 3. Tune them!
- Manually (change and examine)
- Automatically(hyperopt,etc.)
#### Hyperparameter optimization software
- Hyperopt
- Scikit-optimize – Spearmint
- GPyOpt
- RoBO
- SMAC3
#### Automatic hyperparameter optimization
### Color-coding legend
#### <font color=red>Underfitting (bad)</font>
- Increasing it impedes fitting
- Increase it to reduce over fitting
- Decrease to allow model fit easier
#### Good fit and generalization (good)
#### <font color=green>Overfitting (bad)</font>
- Increasing it leads to a better fit (overfit) on train set
- Increase it, if model under fits
- Decrease if overfits
### Summary
#### Hyperparameter tuning in general
- General pipeline
- Manual and automatic tuning
- What should we understand about hyperparameters?
---
#### Models, libraries and hyperparameter optimization
- Tree-basedmodels
- Neural networks
- Linear models
### Tree based models
| Model                    | Where                                                                             |  
|--------------------------|-----------------------------------------------------------------------------------|
| GBDT                     | <p>XGBoost (dmlc/xgboost) <p> LightGBM (Mictrosoft/LighGBM) <p> CatBoost (catboost/catboost) |  
| RandomForest, ExtraTrees | scikit-learn                                                                      |
| Others                   | RGF (baidu/fast_rgf)                                                              |
### GBDT
#### XGBoost
-  <font color=green>max_depth
- subsample
- colsample_bytree, colsample_bylevel</font>
- <font color=red>min_child_weight, lambda, alpha</font>
- <font color=green>eta num_round</font>
#### LightGBM
- <font color=green>max_depth/num_leaves
- bagging_fraction
- feature_fraction</font>
- <font color=red>min_data_in_leaf, lambda_l1, lambda_l2</font>
- <font color=green>learning_rate num_iterations</font>
#### sklearn.RandomForest/ExtraTrees
- <font color=bluee>N_estimators (the higher the better)</font>
- <font color=green>max_depth
- max_features</font>
- <font color=red>min_samples_leaf</font>
- criterion
- random_state
- n_jobs
#### Neural nets
##### What framework to use?
- Keras,Lasagne
- TensorFlow
- MxNet
- PyTorch
#### Parameters
##### <font color=green>Number of neurons per layer</font>
##### <font color=green>Number of layers</font>
##### Optimizers
- <font color=red>SGD + momentum</font>
- <font color=green>Adam/Adadelta/Adagrad/...</font>
##### In practice lead to more overfitting
##### <font color=green>Batch size</font>
##### Learning rate
##### Regularization
- <font color=red>L2/L1 for weights</font>
- <font color=red>Dropout/Dropconnect</font>
- <font color=red>Static dropconnect***</font>
#### Linear models
##### Scikit-learn
- SVC/SVR
##### Sklearn wraps libLinear and libSVM
##### Compile yourself for multicore support
- Logistic Regression/ Linear Regression + regularizers
- SGDClassifier/ SGDRegressor
##### Vowpal Wabbit
- FTRL
##### <font color=red>Regularization parameter (C, alpha, lambda, ...)</font>
- Start with very small value and increase it.
- SVC starts to work slower as C increases
##### Regularization type
- L1/L2/L1+L2 -- try each
- L1 can be used for feature selection
### Tips
##### Don’t spend too much time tuning hyperparameters
- Only if you don’t have any more ideas or you have spare computational resources
##### Be patient
- It can take thousands of rounds for GBDT or neural nets to fit
##### Average everything
- Over random seed
- Or over small deviations from optimal parameters. e.g. average max_depth=4,5,6 for an optimal 5
---
## Practical Guide
### Alexander Guschin
#### Before you enter a competition
##### Define your goals. What you can get out of your participation?
- To learn more about an interesting problem
- To get acquainted with new software tools
- To hunt for a medal
#### After you enter a competition:
##### Working with ideas
- Organize ideas in some structure
- Select the most important and promising ideas
- Try to understand the reasons why something does/doesn’t work
##### Everything is a hyperparameter
Sort all parameters by these principles:
- Importance
- Feasibility
- Understanding

Note: changing one parameter can affect the whole pipeline.
---
### Dmitry Altukhov
#### Data loading
- Do basic preprocessing and convert csv/txt files into hdf5/npy for much faster loading
- Do not forget that by default data is stored in 64-bit arrays, most of the times you can safely downcast it to 32-bits
- Large datasets can be processed in chunks
#### Performance evaluation
- Extensive validation is not always needed
- Start with fastest models - LightGBM
#### Fast and dirty always better
- Don’t pay too much attention to code quality
- Keep things simple: save only important things
- If you feel uncomfortable with given computational resources - rent a larger server
---
### Mikhail Trofimov
#### Initial pipeline
- Start with simple (or even primitive) solution
- Debug full pipeline: From reading data to writing submission file
- “From simple to complex”: I prefer to start with Random Forest rather than Gradient Boosted Decision Trees
#### Best Practices from Software Development
##### Use good variable names
- If your code is hard to read — you definitely will have
problems soon or later
##### Keep your research reproducible
- Fix random seed
- Write down exactly how any features were generated
- Use Version Control Systems (VCS, for example, git)
##### Reuse code
- Especially important to use same code for train and test stages
##### Read papers
###### This can get you ideas about ML-related things
- For example, how to optimize AUC
###### Way to get familiar with problem domain
- Especially useful for feature generation
---
### Dmitry Ulyanov
#### 1. My pipeline
##### Read forums and examine kernels first
- There are always discussions happening!
##### Start with EDA and a baseline
- To make sure the data is loaded correctly
- To check if validation is stable
##### I add features in bulks
- At start I create all the features I can make up
- I evaluate many features at once (not “add one and
evaluate”)
##### Hyperparameters optimization
- First find the parameters to overfit train dataset
- And then try to trim model
#### 2. Code organization: keeping it clean
- Very important to have reproducible results! – Keep important code clean
- Long execution history leads to mistakes
- Your notebooks can become a total mess
- One notebook per submission (and use git)
- Before creating a submission restart the kernel – Use “Restart and run all” button
#### 3. Code organization: test/val
- Split train.csv into train and val with structure of train.csv and test.csv
- When validating, set it at the top of the notebook
- To retrain models on the whole dataset and get predictions for test set just change
#### 4. Code organization: macros
- I use macros for a frequent code
#### 5. Code organization: custom library
##### I use a library with frequent operations implemented – Out-of-fold predictions
- Averaging
- I can specify a classifier by it’s name
---
### Statistics and distance based features
#### Useful features: implementation
#### More features
- How many pages user visited
- Standard deviation of prices
- Most visited page
- Many, many more
#### Neighbors
- Explicit group is not needed
- More flexible
- Much harder to implement
- Number of houses in 500m, 1000m,..
- Average price per square meter in 500m, 1000m,..
- Number of schools/supermarkets/parking lots in 500m, 1000m,..
- Distance to closest subway station
- Explicit group is not needed
- More flexible
- Much harder to implement
#### KNN features in Springleaf
##### Mean encode all the variables
- For every point, find 2000 nearest neighbors using
Bray-Curtis metric
- Calculate various features from those 2000 neighbors
$$ \sum |u_{i}-v_{i} |/ \sum|u_{i}+v_{i}| $$
- Mean target of nearest 5,10,15,500, 2000 neighbors
- Mean distance to 10 closest neighbors
- Mean distance to 10 closest neighbors with target 1
- Mean distance to 10 closest neighbors with target 0
### Matrix Factorizations for Feature Extraction
#### Notes about Matrix Factorization
##### Can be apply only for some columns
##### Can provide additional diversity
- Good for ensembles
##### It is a lossy transformation. Its’ efficiency depends on:
- Particular task
- Number of latent factors. Usually 5-100
#### Implementation
##### Several MF methods you can find in sklearn
##### SVD and PCA
- Standart tools for Matrix Factorization
##### TruncatedSVD
- Work swith sparse matrices
##### Non-negative Matrix Factorization (NMF)
- Ensures that all latent factors are non-negative
- Good for counts-like data
#### NMF for tree-based methods
#### Notes about MF
- Matrix factorization is similar in spirit to linear models.
- You can use the same transformation tricks.
#### Gochas
- Wrong way:` pca = PCA(n_components=5)
  X_train_pca = pca.fit_transform(X_train)
  X_test_pca = pca.fit_transform(X_test)`
- Right way:
  `X_all = np.concatenate([X_train,X_test])
  pca.fit(X_all)
  X_train_pca = pca.transform(X_train)
  X_test_pca = pca.transform(X_test)`
#### Conclusion
- Matrix Factorization is a very general approach for dimensionality reduction and feature extraction
- It can be applied for transforming categorical features into real-valued
- Many of tricks trick suitable for linear models can be useful for MF
### Feature interactions
#### Frequent operations for feature interaction
- Multiplication
- Sum
- Diff
- Division
#### Practical Notes
##### We have a lot of possible interactions − N*N for N features.
- Even more if use several types in interactions
##### Need to reduce its number
- Dimensionality reduction
- Feature selection
#### Example of interaction generation pipeline
- Fit Random Forest
- Get feature importances
- Select a few most important
#### Interactions’ order
- We looked at 2nd order interactions.
- Such approach can be generalized for higher orders.
- It is hard to do generation and selection automatically.
- Manual building of high-order interactions is some kind of art.
#### Extract features from DT
- In sklearn:
   `tree_model.apply()`
- In xgboost:
   `booster.predict(pred_leaf=True)`
### tSNE: Manifold learning methods
#### Practical Notes
##### Result heavily depends on hyperparameters (perplexity)
- Good practice is to use several projections with different perplexities (5-100)
##### Due to stochastic nature, tSNE provides different projections even for the same data\hyperparams
- Train and test should be projected together
##### tSNE runs for a long time with a big number of features
- it is common to do dimensionality reduction before projection.
##### Implementation of tSNE can be found in sklearn library.
##### But personally I prefer you use stand-alone implementation python package tsne due to its’ faster speed.
#### Conclusion
- tSNE is a great tool for visualization
- It can be used as feature as well
- Be careful with interpretation of results
- Try different perplexities
