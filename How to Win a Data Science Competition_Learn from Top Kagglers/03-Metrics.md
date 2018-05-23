
# Evaluation metrics
---
## Metrics optimization

### Motivation
- Chosen metric determines optimal decision boundary
- Predict trend instead of the values:

### Take-away point
If your model is scored with some metric, you get best results by optimizing exactly that metric.

#### Why there are so many metrics?
- Different metrics for different problems

#### Why should we care about metric in competitions?
- It is how the competitors are ranked!
---
## Regression metrics:
### MSE: Mean Square Error
$$ MSE=\frac{1}{N}\sum_{i=1}^{N}(y_{i}-\hat{y_{i}})^2 $$
#### Optimal constant: target mean
$$ MSE=\frac{1}{N}\sum_{i=1}^{N}(y_{i}-\alpha)^2 $$

### RMSE: Root mean square error
$$ RMSE=\sqrt{MSE}=\sqrt{\frac{1}{N}\sum_{i=1}^{N}(y_{i}-\hat{y_{i}})^2} $$

### $R^2$: R-squared
$$ R^2=1-\frac{MSE}{\frac{1}{N}\sum_{i=1}^{N}(y_{i}-\bar{y})^2}=1-\frac{\frac{1}{N}\sum_{i=1}^{N}(y_{i}-\hat{y_{i}})^2}{\frac{1}{N}\sum_{i=1}^{N}(y_{i}-\bar{y})^2} $$

### MAE: Mean absolute error (Robust to outliers)
$$ MAE=\frac{1}{N}\sum_{i=1}^{N}\left|y_{i}-\hat{y_{i}}\right | $$

#### Best constant: target median

#### MAE vs MSE
- Do you have outliers in the data? − Use MAE
- Are you sure they are outliers? − Use MAE
- Or they are just unexpected values we should still care about? − Use MSE

### MSPE
$$ MSPE=\frac{100\%}{N}\sum_{i=1}^{N}(\frac{y_{i}-\hat{y_{i}}}{y_{i}})^2 $$
#### Best constant: weighted target mean
### MAPE
$$ MAE=\frac{100\%}{N}\sum_{i=1}^{N}\left|\frac{y_{i}-\hat{y_{i}}}{y_{i}}\right | $$
#### Best constant: weighted target median
### RMSLE: Root mean square logarithmic error
$$ RMSLE=\sqrt{\frac{1}{N}\sum_{i=1}^{N}(log(y_{i}+1)-log(\hat{y_{i}}+1))^2} $$
#### Best constant in log space is a mean target value

### Conclusion
#### Discussed the metrics, sensitive to relative errors:
#### RMSPE
- Weighted version of MSE
#### MAPE
- Weighted version of MAE
#### RMSLE
- MSE in log space
---
## Classification metrics
- Soft labels (soft predictions) are classifier’s scores
- Hard labels (hard predictions)

### Accuracy score
- How frequently our class prediction is correct.
$$ Accuray=\frac{1}{N}\sum_{i=1}^{N}\left [\hat{y_{i}}=y_{i}\right ] $$
#### Best constant: predict the most frequent class.

### Logarithmic loss (LoglLoss)
- Binary:
$$ LogLoss=-\frac{1}{N}\sum_{i=1}^{N}(y_{i}log(\hat{y_{i}}+(1-y_{i})log(1-\hat{y_{i}})) $$

- Multiclass:
$$ LogLoss=-\frac{1}{N}\sum_{i=1}^{N}\sum_{l=1}^{L}y_{il}log(\hat{y}_{il})
$$

- In practice:
$$ LogLoss=-\frac{1}{N}\sum_{i=1}^{N}\sum_{l=1}^{L}y_{il}log(min(max(\hat{y}_{il},10^{-15}),1-10^{-15}))
$$

#### Best constant: set $\alpha_{𝒊}$ to frequency of $𝒊-th$ class.

### Area Under Curve (AUC ROC)
- Only for binary tasks
- Depends only on ordering of the predictions, not on absolute values
$$ AUC=\frac{\ #Correctly\ odor\ pairs}{Total\ number\ of\ pairs}= 1-\frac{\ #Incorrectly\ odor\ pairs}{Total\ number\ of\ pairs} $$

#### Several explanations
- Area under curve
- Pairs ordering

#### Best constant: All constants give same score
- Random predictions lead to AUC = 0.5

### Cohen’s Kappa motivation
$$ Cohen’s\ Kappa =1-\frac{1-accuracy}{1-p_{e}}=1-\frac{error}{baseline\ error} $$
- $p_{e}$ - what accuracy would be on average, if we randomly permute our predictions
$$ p_{e}= \frac{1}{N^2}\sum_{k}n_{k1}n_{k2}$$

### Weighted error and weighted Kappa
- Confusion matrix $C$
- Weight matrix $W$

$$ Weight\ error = \frac{1}{const}\sum_{i,j}C_{ij}W_{ij} $$
$$ Weight\ Kappa =1- \frac{Weight\ error}{Weight\ baseline\  error} $$

### Quadratic and Linear Weighted Kappa
- Linear weights $w_{ji}=\left |i-j  \right |$
- Quadratic weights $w_{ji}=(i-j)^2$
---
## General approaches for metrics optimization
- Optimize loss function
### Loss and metric
- Target metric is what we want to optimize
- Optimization loss is what model optimizes
- Synonyms: loss, cost, objective

### Approaches for target metric optimization
- Just run the right model! - MSE, Logloss
- Preprocess train and optimize another metric - MSPE, MAPE, RMSLE, ...
- Optimize another metric, postprocess predictions - Accuracy, Kappa
- Write custom loss function - Any, if you can
- Optimize another metric, use early stopping - Any

### Early stopping
- Optimize metric M1, monitor metric M2
- Stop when M2 score is the best
---
### Regression metrics optimization
#### RMSE, MSE, R-squared
- Just fit the right model!
- Synonyms: L2 loss
##### Tree-based
- XGBoost, LightGBM
- sklearn.RandomForestRegressor
##### Linear models
- sklearn.<>Regression
- sklearn.SGDRegressor
- Vowpal Wabbit (quantile loss)
##### Neural nets
- PyTorch, Keras, TF, etc.

#### MAE
- Again, just run the right model!
- Synonyms: L1, Median regression

##### Tree-based
- ~~XGBoost~~, LightGBM
- sklearn.RandomForestRegressor

##### Linear models
- ~~sklearn.<>Regression~~
- ~~sklearn.SGDRegressor~~
- Vowpal Wabbit (quantile loss)

##### Neural nets
- PyTorch, Keras, TF, etc.

#### MSPE (MAPE) as weighted MSE (MAE)
$$ MSPE=\frac{100\%}{N}\sum_{i=1}^{N}(\frac{y_{i}-\hat{y_{i}}}{y_{i}})^2 \ w{i}=\frac{y_{i}^{-2}}{\sum_{i=1}^{N}y_{i}^{-2}} $$
$$ MAE=\frac{100\%}{N}\sum_{i=1}^{N}\left|\frac{y_{i}-\hat{y_{i}}}{y_{i}}\right |\
w{i}=\frac{y_{i}^{-1}}{\sum_{i=1}^{N}y_{i}^{-1}} $$
- $w_{i}$ - Sample weights.

##### Use weights for samples (`sample_weights`) – And use MSE (MAE)
##### Not every library accepts sample weights
- XGBoost,LightGBM accept
- Neural nets
- Easy to implement if not supported
##### Resample the train set
- `df.sample(weights=sample_weights)`
- And use any model that optimizes MSE (MAE)
- Usually need to resample many times and average

#### RMSLE
##### Train:
- Transform target: $z_{i}=log(y_{i}+1)$
- Fit a model with MSE loss
##### Test:
- Transform predictions back: $\hat{y}_{i}=exp(\hat{z}_{i})-1$
---
### Classification metrics optimization: Logloss and accuracy

#### Logloss
- Just run the right model!
- Synonyms: Logistic loss
##### Tree-based
- XGBoost, LightGBM
- ~~sklearn.RandomForestClassifier~~
##### Linear models
- sklearn.<>Regression
- sklearn.SGDRegressor
- Vowpal Wabbit
##### Neural nets
- PyTorch, Keras, TF, etc.

##### Probability calibration
###### Plattscaling
- JustfitLogisticRegressiontoyourpredictions (like in stacking)
###### Isotonicregression
- Just fit Isotonic Regression to your predictions (like in stacking)
###### Stacking
- Just fit XGBoost or neural net to your predictions

#### Accuracy
- Fit any metric and tune treshold!

#### AUC (ROC)
- Run the right model, or just optimize logloss.
##### Pointwise loss
$$ Loss=min\sum_{i}^{N}\sum_{j}^{N}l_{pair}(\hat{y}_{i},\hat{y}_{j};y_{i},y_{j}) $$
##### Pairwise loss
$$ Loss = -\frac{1}{N_{0}N_{1}}\sum_{j:y_{j}=1}^{N_{1}}\sum_{i:y_{i}=0}^{N_{0}}log(prob(\hat{y}_{j}-\hat{y}_{i}))   $$
##### Tree-based
- XGBoost, LightGBM
- ~~sklearn.RandomForestClassifier~~
##### Linear models
- ~~sklearn.<>Regression~~
- ~~sklearn.SGDRegressor~~
- ~~Vowpal Wabbit~~
##### Neural nets
- PyTorch, Keras, TF, etc.

#### Quadratic weighted Kappa
- Optimize MSE and find right thresholds – Simple
- Custom smooth loss for GBDT or neural nets – Harder

##### MSE + tresholds
###### Optimize MSE
###### Find right thresholds
- Bad:np.round(predictions)
- Better: optimize thresholds
---
# Using target to generate features ***
- Mean Coding/Likely Coding
- **Add new variables based on some features to get where we stared.**
- There are a lot ways to regularize mean encodings
- Unending battle with target variable leakage
- CV loop or Expanding mean for practical tasks
- **More complicated and non-liner featuers target dependency, the more effective is mean encoding!**

### Why does it work?
- Label encoding gives random order. No correlation with target
- Mean encoding helps to separate zeros from ones

### What will you learn?
- Construct encodings
- Correctly validate them
- Extend them

### Ways to use target variable
- Goods - number of ones in a group
- Bads - number of zeros
- Indicators of usefulness

$$ Likelihood=\frac{Goods}{Goods+Bads} $$
$$ Weight\ of\ Evidence =ln(\frac{Goods}{Bads}\times 100) $$
$$ Count = Goods = sum(Target)$$
$$ Diff = Goods - Bads $$

### Overfitting
- We need to deal with Overfitting first, we need some kind of regularization!

## Regularization
### CV loop
- Robust and intuitive
- Usually decent results with 4-5 folds across different datasets
- Need to be careful with extreme situations like LOO

- Perfect feature for LOO scheme
- Target variable leakage is still present even for KFold scheme

### Smoothing
- Alpha (Hyperparameter, = cluster number) controls the amount of regularization
- Only works together with some other regularization method
$$ \frac{mean(target)\times nrows+globalmean \times \alpha}{nrows+\alpha} $$
- **Always with other method**
- Small sample size and some clusters

### Noise
- Noise degrades the quality of encoding - Unstable
- How much noise should we add? **
- Usually used together with LOO
- **Diligently fine tune it!**

### Expanding mean
- Least amount of leakage
- No hyper parameters
- Irregular encoding quality
- Built - in in CatBoost
- **Features quality is not uniform (Bad)**

## Generalizations and extensions

- Using target variable in different tasks. Regression, multiclass
- Domains with many-to-many relations
- Timeseries
- Encoding interactions and numerical features

### Regression and multiclass
- More statistics for regression tasks. Percentiles, std, distribution bins.
- Introducing new information for one vs all classifiers in multi class tasks

#### Many-to-many relations (Long presentation --> mean encoding)
- Cross product of entities
- Statistics from vectors

### Time series
- Time structure allows us to make a lot of complicated features.
- Rolling statistics of target variable

### Interactions and numerical features
- Analyzing fitted model
- **Binning numeric and selecting interactions**

#### How to bin it?
- Too many values -- mean coding
- Analyzing model structure


## Correct validation reminder
### Local experiments:
- Estimate encodings on X_tr
- Map them to X_tr and X_val
- Regularize on X_tr
- Validate model on X_tr/ X_val split
### Submission:
- Estimate encodings on whole Train data
- Map them to Train and Test
- Regularize on Train
- Fit on Train

### Main advantages:
- Compact transformation of categorical variables
- Powerful basis for feature engineering
### Disadvantages:
- Need careful validation, there a lot of ways to overfit
- Significant improvements only on specific datasets
