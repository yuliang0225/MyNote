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
$$ Accuray=\frac{1}{N}\sum_{i=1}^{N}\left [\hat{y_{i}=y_{i}}\right ] $$
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
$$ AUC=\frac{\#Correctly\ odor\ pairs}{Total\ number\ of\ pairs}= 1-\frac{\#Incorrectly\ odor\ pairs}{Total\ number\ of\ pairs} $$

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
##
