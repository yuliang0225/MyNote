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
